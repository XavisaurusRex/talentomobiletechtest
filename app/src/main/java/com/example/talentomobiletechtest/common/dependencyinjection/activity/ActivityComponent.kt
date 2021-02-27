package com.example.talentomobiletechtest.common.dependencyinjection.activity

import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, UseCaseModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

}