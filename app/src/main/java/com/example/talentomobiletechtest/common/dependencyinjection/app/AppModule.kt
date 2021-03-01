package com.example.talentomobiletechtest.common.dependencyinjection.app

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(val application: Application) {

    @Provides
    fun application() = application

}