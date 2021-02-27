package com.example.talentomobiletechtest.common.dependencyinjection.presentation

import com.example.talentomobiletechtest.common.view.fragment.ErrorDialogFragment
import com.example.talentomobiletechtest.common.view.fragment.LoadingDialogFragment
import com.example.talentomobiletechtest.feature.themes.view.activity.ThemesSelectionActitivity
import dagger.Subcomponent

@PresentationScope
@Subcomponent
interface PresentationComponent {

    fun inject(activity: ThemesSelectionActitivity)

    fun inject(fragment: LoadingDialogFragment)

    fun inject(errorDialogFragment: ErrorDialogFragment)

}