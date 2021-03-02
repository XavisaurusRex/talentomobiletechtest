package com.example.talentomobiletechtest.common.view.fragment

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.DialogFragment
import com.example.talentomobiletechtest.R
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.view.activity.BaseActivity

abstract class BaseDialogFragment : DialogFragment() {

    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent()
    }

    private val injector get() = presentationComponent

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectView(injector)
        setStyle(STYLE_NORMAL, R.style.Theme_App_Dialog_FullScreen)

        super.onCreate(savedInstanceState)
    }


    abstract fun injectView(presentationComponent: PresentationComponent)
}