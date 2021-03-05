package com.example.talentomobiletechtest.common.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.databinding.FragmentErrorDialogBinding
import com.example.talentomobiletechtest.feature.details.view.fragment.CenterDetailsFragmentArgs

class ErrorDialogFragment : BaseDialogFragment() {

    val args: ErrorDialogFragmentArgs by navArgs()

    private lateinit var binding: FragmentErrorDialogBinding

    override fun injectView(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.errorMessage?.let {
            binding.tvErrorMessage.text = it
        }

        binding.tvErrorAction.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}