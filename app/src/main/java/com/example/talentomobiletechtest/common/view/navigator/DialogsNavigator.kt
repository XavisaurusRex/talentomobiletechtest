package com.example.talentomobiletechtest.common.view.navigator

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.talentomobiletechtest.common.view.fragment.ErrorDialogFragment
import com.example.talentomobiletechtest.common.view.fragment.LoadingDialogFragment

class DialogsNavigator(private val fragmentManager: FragmentManager) {

    fun showLoading(loadingMessage: String?) {
        val loadingFragment = fragmentManager.findFragmentByTag(LOADING_DIALOG_FRAGMENT)
        if (loadingFragment == null) {
            fragmentManager.beginTransaction()
                .add(LoadingDialogFragment.newInstance(loadingMessage), LOADING_DIALOG_FRAGMENT)
                .addToBackStack(LOADING_DIALOG_FRAGMENT)
                .commit()
        } else if (loadingFragment.isAdded.not()) {
            (loadingFragment as DialogFragment).show(fragmentManager, LOADING_DIALOG_FRAGMENT)
        }
    }

    fun hideLoading() {
        fragmentManager.findFragmentByTag(LOADING_DIALOG_FRAGMENT)?.let {
            fragmentManager.popBackStack()
        }
    }

    fun hideError() {
        fragmentManager.findFragmentByTag(ERROR_DIALOG_FRAGMENT)?.let {
            fragmentManager.popBackStack()
        }
    }

    fun showErrorDialog(errorMessage: String? = null) {
        val errorDialog = fragmentManager.findFragmentByTag(ERROR_DIALOG_FRAGMENT)
        if (errorDialog == null) {
            fragmentManager.beginTransaction()
                .add(ErrorDialogFragment.newInstance(errorMessage), ERROR_DIALOG_FRAGMENT)
                .addToBackStack(ERROR_DIALOG_FRAGMENT)
                .commit()
        } else if (errorDialog.isAdded.not()) {
            (errorDialog as DialogFragment).show(fragmentManager, ERROR_DIALOG_FRAGMENT)
        }
    }

    companion object {
        const val LOADING_DIALOG_FRAGMENT = "Loading Fragment"
        const val ERROR_DIALOG_FRAGMENT = "Error Fragment"
    }
}