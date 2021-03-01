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
import com.example.talentomobiletechtest.feature.themes.data.model.Center
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
            viewModel.updateCentersList(true)
        }

        setUpObservers()

        if (viewModel.themesAlreadyRequested.not()) {
            viewModel.updateCentersList()
        }
    }

    private fun setUpObservers() {
        viewModel.availableCenters.observe(::getLifecycle) { updateList(it) }
    }

    private fun updateList(response: Resource<List<Center>>) {
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

    private fun manageSuccessResponse(data: List<Center>) {
        val stringBuilder = StringBuilder()
        data.forEach {
            stringBuilder.append(it.name).append(", ")
        }

        binding.tvMain.text = stringBuilder.toString()
    }

}