package com.example.talentomobiletechtest.common.dependencyinjection.activity

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(
    val activity: AppCompatActivity
) {

    @Provides
    fun activity() = activity

    @Provides
    fun provideContext(): Context = activity

    @Provides
    @ActivityScope
    fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    fun layoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

}