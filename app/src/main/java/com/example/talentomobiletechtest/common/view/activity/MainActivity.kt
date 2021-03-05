package com.example.talentomobiletechtest.common.view.activity

import android.os.Bundle
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import com.example.talentomobiletechtest.common.view.activity.BaseActivity
import com.example.talentomobiletechtest.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    override fun injectView(presentationComponent: PresentationComponent) {
        presentationComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}