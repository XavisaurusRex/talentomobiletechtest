package com.example.talentomobiletechtest.common.view.activity

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.example.talentomobiletechtest.common.dependencyinjection.TMTTApplication
import com.example.talentomobiletechtest.common.dependencyinjection.activity.ActivityComponent
import com.example.talentomobiletechtest.common.dependencyinjection.activity.ActivityModule
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationModule

abstract class BaseActivity : AppCompatActivity() {

    private val appComponent get() = (application as TMTTApplication).appComponent

    val activityComponent: ActivityComponent by lazy {
        appComponent.newActivityComponent(ActivityModule(this))
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule(this))
    }

    private val injector get() = presentationComponent

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectView(injector)
        super.onCreate(savedInstanceState)
    }

    abstract fun injectView(presentationComponent: PresentationComponent)
}