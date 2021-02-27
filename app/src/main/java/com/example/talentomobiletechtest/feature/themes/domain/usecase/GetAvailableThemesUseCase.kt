package com.example.talentomobiletechtest.feature.themes.domain.usecase

import com.example.talentomobiletechtest.common.domain.ResponseWrapper
import com.example.talentomobiletechtest.feature.themes.data.remote.AvailableThemesRequest
import com.example.talentomobiletechtest.feature.themes.view.adapter.dw.ThemeDataWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetAvailableThemesUseCase(
    private val request: AvailableThemesRequest
) {
    suspend fun execute(): ResponseWrapper<List<ThemeDataWrapper>> =
        withContext(Dispatchers.IO) {

            val availableThemesResponseWrapper = request.getAvailableThemes()

            return@withContext if (availableThemesResponseWrapper is ResponseWrapper.Success) {
                try {
                    val themeDataWrappers: ArrayList<ThemeDataWrapper> = arrayListOf()
                    availableThemesResponseWrapper.data.result.items.forEach {
                        themeDataWrappers.add(ThemeDataWrapper(
                            it.notation,
                            it.prefLabel
                        ))
                    }

                    ResponseWrapper.Success(themeDataWrappers)
                } catch (exception: Exception) {
                    ResponseWrapper.Error(exception)
                }
            } else ResponseWrapper.Error()
        }

}