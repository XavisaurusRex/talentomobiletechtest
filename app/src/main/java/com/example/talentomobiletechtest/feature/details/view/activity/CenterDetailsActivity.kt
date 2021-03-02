package com.example.talentomobiletechtest.feature.details.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.talentomobiletechtest.R
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.view.activity.BaseActivity
import com.example.talentomobiletechtest.common.view.navigator.DialogsNavigator
import com.example.talentomobiletechtest.common.view.viewmodel.Resource
import com.example.talentomobiletechtest.databinding.ActivityCenterDetailsBinding
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.details.view.viewmodel.CenterDetailsViewModel
import javax.inject.Inject

class CenterDetailsActivity : BaseActivity() {

    private lateinit var binding: ActivityCenterDetailsBinding

    @Inject
    lateinit var dialogsNavigator: DialogsNavigator

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CenterDetailsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CenterDetailsViewModel::class.java]
    }

    override fun injectView(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCenterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpObservers()

        if (viewModel.detailsAlreadyRequested.not()) {
            getCenterUrlIdFromExtras()?.let {
                viewModel.requestCentersDetails(it)
            }
        }
    }

    private fun setUpObservers() {
        viewModel.centerDetails.observe(::getLifecycle) { updateCenterDetails(it) }
    }

    private fun updateCenterDetails(response: Resource<Center>) {
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
        viewModel.detailsAlreadyRequested = true
    }

    private fun manageSuccessResponse(center: Center) {
        binding.tvValueRefId.text = center.refId
        binding.tvValueType.text = center.type
        binding.tvValueId.text = center.id
        binding.tvValueTitle.text = center.title
        binding.tvValueRelation.text = center.relation
        binding.tvOtherInfo.text = "" +
                "locality --> ${center.address.locality}\n" +
                "postalCode --> ${center.address.postalCode}\n" +
                "streetAddress --> ${center.address.streetAddress}\n" +
                "latitude --> ${center.location.latitude}\n" +
                "longitude --> ${center.location.longitude}\n" +
                "organizationDesc --> ${center.organization.organizationDesc}\n" +
                "schedule --> ${center.organization.schedule}\n" +
                "services --> ${center.organization.services}\n" +
                "organizationName --> ${center.organization.organizationName}"
    }

    private fun getCenterUrlIdFromExtras(): String? = intent.getStringExtra(EXTRA_CENTER_URL_ID)


    companion object {

        private const val EXTRA_CENTER_URL_ID = "extra_center_url_id"

        fun start(context: Context, centerUrlId: String) {
            val intent = Intent(context, CenterDetailsActivity::class.java)
            intent.putExtra(EXTRA_CENTER_URL_ID, centerUrlId)
            context.startActivity(intent)
        }

    }
}