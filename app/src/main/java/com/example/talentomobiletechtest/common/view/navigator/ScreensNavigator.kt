package com.example.talentomobiletechtest.common.view.navigator

import androidx.appcompat.app.AppCompatActivity

class ScreensNavigator(private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

}