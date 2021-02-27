package com.example.talentomobiletechtest.common.dependencyinjection.activity

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.talentomobiletechtest.common.view.viewmodel.VTTViewModelFactory
import com.example.talentomobiletechtest.common.view.navigator.DialogsNavigator
import com.example.talentomobiletechtest.common.view.navigator.ScreensNavigator
import com.example.talentomobiletechtest.feature.themes.domain.usecase.GetAvailableThemesUseCase
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
    fun provideViewModelFactory(
        getAvailableThemesUseCase: GetAvailableThemesUseCase
    ): VTTViewModelFactory =
        VTTViewModelFactory(
            getAvailableThemesUseCase
        )

    @Provides
    @ActivityScope
    fun screensNavigator(activity: AppCompatActivity) = ScreensNavigator(activity)

    @Provides
    @ActivityScope
    fun dialogsNavigator(fragmentManager: FragmentManager) = DialogsNavigator(fragmentManager)

    @Provides
    @ActivityScope
    fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

    @Provides
    fun layoutInflater(activity: AppCompatActivity): LayoutInflater = LayoutInflater.from(activity)

}