package com.example.talentomobiletechtest.feature.centersfeed.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.talentomobiletechtest.R
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.view.fragment.BaseFragment
import com.example.talentomobiletechtest.databinding.FragmentCentersFeedBinding
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.CentersAdapter
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.dw.CenterDataWrapper
import com.example.talentomobiletechtest.feature.centersfeed.view.adapter.listener.CenterAdapterListener
import com.example.talentomobiletechtest.feature.centersfeed.view.viewmodel.CentersFeedViewModel
import javax.inject.Inject

class CentersFeedFragment : BaseFragment(), CenterAdapterListener {

    lateinit var binding: FragmentCentersFeedBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CentersFeedViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CentersFeedViewModel::class.java]
    }

    override fun injectView(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCentersFeedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.availableCenters.observe(::getLifecycle) { updateList(it) }
        viewModel.loading.observe(::getLifecycle) { showLoading(it) }
        viewModel.error.observe(::getLifecycle) { showError(it) }
    }

    private fun updateList(dataWrappers: List<CenterDataWrapper>?) {
        dataWrappers?.let {
            binding.rcyCentersFeed.adapter = CentersAdapter(this, it)
        }
    }

    override fun onCenterClicked(center: Center) {
        findNavController().navigate(
            CentersFeedFragmentDirections.actionCentersfeedToCenterdetails(
                center
            )
        )
    }

    private fun showError(errorHandler: Pair<Boolean, String?>) {
        if (errorHandler.first) {
            if (findNavController().currentDestination?.id != R.id.dialogError) {
                findNavController().navigate(
                    CentersFeedFragmentDirections.actionCentersFeedFragmentToDialogError(
                        errorHandler.second
                    )
                )
            }
        } else {
            findNavController().popBackStack(R.id.dialogError, true)
        }
    }

    private fun showLoading(show: Boolean) {
        if (show) {
            if (findNavController().currentDestination?.id != R.id.dialogLoading) {
                findNavController().navigate(
                    CentersFeedFragmentDirections.actionCentersFeedFragmentToDialogLoading("Custom Loading message")
                )
            }
        } else {
            findNavController().popBackStack(R.id.dialogLoading, true)
        }
    }

}
