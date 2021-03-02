package com.example.talentomobiletechtest.feature.centersfeed.view.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.talentomobiletechtest.R
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.view.activity.BaseActivity
import com.example.talentomobiletechtest.common.view.navigator.DialogsNavigator
import com.example.talentomobiletechtest.common.view.navigator.ScreensNavigator
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.databinding.ActivityCentersFeedBinding
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.CentersAdapter
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.FamilyCareCenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.HomelessCenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.listener.CenterAdapterListener
import com.example.talentomobiletechtest.feature.centersfeed.view.viewmodel.CentersFeedViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class CentersFeedActivity : BaseActivity(), CenterAdapterListener {

    private lateinit var binding: ActivityCentersFeedBinding

    @Inject
    lateinit var dialogsNavigator: DialogsNavigator

    @Inject
    lateinit var screensNavigator: ScreensNavigator

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CentersFeedViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CentersFeedViewModel::class.java]
    }

    override fun injectView(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCentersFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpObservers()

        if (viewModel.themesAlreadyRequested.not()) {
            viewModel.updateCentersList()
        }
    }

    private fun setUpObservers() {
        viewModel.availableCenter.observe(::getLifecycle) { updateList(it) }
    }

    private fun updateList(response: Resource<List<CenterDataWrapper>>) {
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

    private fun manageSuccessResponse(data: List<CenterDataWrapper>) {
        val adapter = CentersAdapter(this)
        binding.rcyCentersFeed.adapter = adapter
        adapter.setData(data)
    }

    override fun onHomelessCenterClicked(homelessCenterDataWrapper: HomelessCenterDataWrapper) {
        Snackbar.make(
            binding.rcyCentersFeed,
            "homelessCenterDataWrapper -> ${homelessCenterDataWrapper.item.name}",
            Snackbar.LENGTH_LONG
        ).show();
        screensNavigator.navigateToCenterDetails(this, homelessCenterDataWrapper.item.id)
    }

    override fun onFamilyCareCenterClicked(familyCareCenterDataWrapper: FamilyCareCenterDataWrapper) {
        Snackbar.make(
            binding.rcyCentersFeed,
            "familyCareCenterDataWrapper -> ${familyCareCenterDataWrapper.item.name}",
            Snackbar.LENGTH_LONG
        ).show();
        screensNavigator.navigateToCenterDetails(this, familyCareCenterDataWrapper.item.id)
    }

}