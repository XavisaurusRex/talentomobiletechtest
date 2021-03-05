package com.example.talentomobiletechtest.feature.details.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.view.fragment.BaseFragment
import com.example.talentomobiletechtest.databinding.FragmentCenterDetailsBinding
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

class CenterDetailsFragment : BaseFragment() {

    lateinit var binding: FragmentCenterDetailsBinding

    val args: CenterDetailsFragmentArgs by navArgs()

    override fun injectView(presentationComponent: PresentationComponent) {
        // no op
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCenterDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupCenterDetails(args.centerDetails)
    }

    private fun setupCenterDetails(center: Center) {
        binding.tvValueRefId.text = center.refId
        binding.tvValueType.text = center.type
        binding.tvValueId.text = center.id
        binding.tvValueTitle.text = center.title
        binding.tvValueRelation.text = center.relation
        binding.tvOtherInfo.text = "" +
                "locality --> ${center.address?.locality}\n" +
                "postalCode --> ${center.address?.postalCode}\n" +
                "streetAddress --> ${center.address?.streetAddress}\n" +
                "latitude --> ${center.location?.latitude}\n" +
                "longitude --> ${center.location?.longitude}\n" +
                "organizationDesc --> ${center.organization?.organizationDesc}\n" +
                "schedule --> ${center.organization?.schedule}\n" +
                "services --> ${center.organization?.services}\n" +
                "organizationName --> ${center.organization?.organizationName}"

    }
}