package com.example.talentomobiletechtest.common.dependencyinjection.app

import com.example.talentomobiletechtest.common.dependencyinjection.activity.ActivityComponent
import com.example.talentomobiletechtest.common.dependencyinjection.activity.ActivityModule
import com.example.talentomobiletechtest.common.dependencyinjection.activity.UseCaseModule
import com.example.talentomobiletechtest.common.dependencyinjection.activity.ViewModelModule
import dagger.Component

@AppScope
@Component(modules = [AppModule::class, RepositoryModule::class, ConverterModule::class])
interface AppComponent {

    fun newActivityComponent(activityModule: ActivityModule): ActivityComponent

}