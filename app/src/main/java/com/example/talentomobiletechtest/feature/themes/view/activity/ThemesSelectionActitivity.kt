package com.example.talentomobiletechtest.feature.themes.view.activity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.talentomobiletechtest.R
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.view.activity.BaseActivity
import com.example.talentomobiletechtest.common.view.navigator.DialogsNavigator
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.common.view.viewmodel.VTTViewModelFactory
import com.example.talentomobiletechtest.databinding.ActivityThemeSelectionBinding
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.ThemeDataWrapper
import com.example.talentomobiletechtest.feature.themes.view.viewmodel.AvailableThemesViewModel
import javax.inject.Inject

class ThemesSelectionActitivity : BaseActivity() {

    private lateinit var binding: ActivityThemeSelectionBinding

    @Inject
    lateinit var dialogsNavigator: DialogsNavigator

    @Inject
    lateinit var viewModelFactory: VTTViewModelFactory


    private val viewModel: AvailableThemesViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(AvailableThemesViewModel::class.java)
    }

    override fun injectView(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThemeSelectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMain.setOnClickListener {
            viewModel.updateAllCenters(true)
        }

        setUpObservers()

        if (viewModel.themesAlreadyRequested.not()) {
            viewModel.updateThemesList()
        }
    }

    private fun setUpObservers() {
        viewModel.availableThemesList.observe(::getLifecycle) { updateList(it) }
    }

    private fun updateList(response: Resource<List<ThemeDataWrapper>>) {
        Log.d("ThreadsInfo", "Simply Execute the livedata update")
        when (response) {
            is Resource.Loading -> dialogsNavigator.showLoading(getString(R.string.dialog_availablethemes_loading_message))
            is Resource.Success -> {
                dialogsNavigator.hideLoading()
                manageSuccessResponse(response.data)
            }
            is Resource.UnknownError -> {
                dialogsNavigator.hideLoading()
                dialogsNavigator.showErrorDialog(response.throwable.message)
            }
        }
        viewModel.themesAlreadyRequested = true
    }

    private fun manageSuccessResponse(data: List<ThemeDataWrapper>) {
        val stringBuilder = StringBuilder()
        data.forEach {
            stringBuilder.append(it.id).append(", ")
        }

        binding.tvMain.text = stringBuilder.toString()
    }

}