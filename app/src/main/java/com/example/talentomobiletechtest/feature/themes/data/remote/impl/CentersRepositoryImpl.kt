package com.example.talentomobiletechtest.feature.themes.data.remote.impl

import com.example.talentomobiletechtest.common.data.repository.RetrofitCentersRepository
import com.example.talentomobiletechtest.common.dependencyinjection.app.CenterListConverter
import com.example.talentomobiletechtest.common.utils.RestException
import com.example.talentomobiletechtest.feature.themes.data.model.Center
import com.example.talentomobiletechtest.feature.themes.data.remote.CentersRepository

class CentersRepositoryImpl(
    private val repository: RetrofitCentersRepository,
    private val converter: CenterListConverter,
) : CentersRepository {

    override fun requestJuvenileAndFamilyCareCenters(): List<Center> {
        val call = repository.getJuvenileAndFamilyCareCenters()
        val response = call.execute();
        if (response.isSuccessful) {
            return converter.convert(response.body()!!)
        } else throw RestException(response.errorBody()!!.toString())
    }

    override fun requestCentersForHomelessPeople(): List<Center> {
        val call = repository.getCentersForHomelessPeople()
        val response = call.execute();
        if (response.isSuccessful) {
            return converter.convert(response.body()!!)
        } else throw RestException(response.errorBody()!!.toString())
    }

}