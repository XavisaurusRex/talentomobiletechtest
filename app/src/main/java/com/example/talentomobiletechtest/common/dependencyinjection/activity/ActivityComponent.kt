package com.example.talentomobiletechtest.common.dependencyinjection.activity

import com.example.talentomobiletechtest.common.dependencyinjection.activity.scopes.ActivityScope
import com.example.talentomobiletechtest.common.dependencyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, ViewModelModule::class, UseCaseModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

}