package com.example.talentomobiletechtest.common.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.databinding.FragmentLoadingDialogBinding

class LoadingDialogFragment : BaseDialogFragment() {

    val args: LoadingDialogFragmentArgs by navArgs()

    private lateinit var binding: FragmentLoadingDialogBinding

    override fun injectView(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadingDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.loadingMessage?.let {
            binding.tvLoadingMessage.text = it
        }

    }
}