package com.example.talentomobiletechtest.common.view.fragment

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationModule
import com.example.talentomobiletechtest.common.view.activity.BaseActivity

abstract class BaseFragment: Fragment() {
    private val presentationComponent by lazy {
        (requireActivity() as BaseActivity).activityComponent.newPresentationComponent(
            PresentationModule(this)
        )
    }

    private val injector get() = presentationComponent

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectView(injector)
        super.onCreate(savedInstanceState)
    }

    abstract fun injectView(presentationComponent: PresentationComponent)

}
