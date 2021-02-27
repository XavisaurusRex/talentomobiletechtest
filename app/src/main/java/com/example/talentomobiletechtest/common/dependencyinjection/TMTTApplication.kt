package com.example.talentomobiletechtest.common.dependencyinjection

import android.app.Application
import com.example.talentomobiletechtest.common.dependencyinjection.app.AppComponent
import com.example.talentomobiletechtest.common.dependencyinjection.app.AppModule
import com.example.talentomobiletechtest.common.dependencyinjection.app.DaggerAppComponent

class TMTTApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

}