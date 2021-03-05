package com.example.talentomobiletechtest.common.dependencyinjection.presentation

import com.example.talentomobiletechtest.common.view.fragment.ErrorDialogFragment
import com.example.talentomobiletechtest.common.view.fragment.LoadingDialogFragment
import com.example.talentomobiletechtest.common.view.activity.MainActivity
import com.example.talentomobiletechtest.feature.centersfeed.view.fragment.CentersFeedFragment
import dagger.Subcomponent

@PresentationScope
@Subcomponent(modules = [PresentationModule::class, ViewModelModule::class])
interface PresentationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: LoadingDialogFragment)

    fun inject(errorDialogFragment: ErrorDialogFragment)

    fun inject(centersFeedFragment: CentersFeedFragment)

}