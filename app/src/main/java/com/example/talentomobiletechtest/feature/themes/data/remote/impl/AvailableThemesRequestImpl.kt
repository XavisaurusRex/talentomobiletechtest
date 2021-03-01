package com.example.talentomobiletechtest.feature.themes.data.remote.impl

import com.example.talentomobiletechtest.common.data.repository.MadridThemesRepository
import com.example.talentomobiletechtest.common.utils.RestException
import com.example.talentomobiletechtest.feature.themes.data.model.ApiThemesRoot
import com.example.talentomobiletechtest.feature.themes.data.remote.AvailableThemesRequest

class AvailableThemesRequestImpl(
    private val repository: MadridThemesRepository
) : AvailableThemesRequest {

    override fun getAvailableThemes(): ApiThemesRoot {
        val call = repository.getApiThemesRootCall()
        val response = call.execute();
        if (response.isSuccessful) {
            return response.body()!!
        } else throw RestException(response.errorBody()!!.toString())
    }

}