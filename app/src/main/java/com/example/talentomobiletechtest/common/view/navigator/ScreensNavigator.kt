package com.example.talentomobiletechtest.common.view.navigator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.talentomobiletechtest.feature.details.view.activity.CenterDetailsActivity

class ScreensNavigator(private val activity: AppCompatActivity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun navigateToCenterDetails(context: Context, centerUrlId: String) {
        CenterDetailsActivity.start(context, centerUrlId)
    }

}