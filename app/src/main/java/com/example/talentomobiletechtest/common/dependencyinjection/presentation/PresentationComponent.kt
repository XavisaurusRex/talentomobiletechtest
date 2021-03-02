package com.example.talentomobiletechtest.common.dependencyinjection.presentation

import com.example.talentomobiletechtest.common.view.fragment.ErrorDialogFragment
import com.example.talentomobiletechtest.common.view.fragment.LoadingDialogFragment
import com.example.talentomobiletechtest.feature.centersfeed.view.activity.CentersFeedActivity
import com.example.talentomobiletechtest.feature.details.view.activity.CenterDetailsActivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent
interface PresentationComponent {

    fun inject(activity: CentersFeedActivity)

    fun inject(fragment: LoadingDialogFragment)

    fun inject(errorDialogFragment: ErrorDialogFragment)

    fun inject(centerDetailsActivity: CenterDetailsActivity)

}