package com.example.talentomobiletechtest.feature.centersfeed.data.remote.impl

import com.example.talentomobiletechtest.common.data.repository.RetrofitCentersRepository
import com.example.talentomobiletechtest.feature.centersfeed.data.mapper.CenterListConverter
import com.example.talentomobiletechtest.common.utils.RestException
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.centersfeed.data.remote.CentersRepository
import java.net.UnknownHostException

class CentersRepositoryImpl(
    private val repository: RetrofitCentersRepository,
    private val converter: CenterListConverter,
) : CentersRepository {

    override fun requestJuvenileAndFamilyCareCenters(): List<Center> {
        val call = repository.getJuvenileAndFamilyCareCenters()
        try {
            val response = call.execute();
            if (response.isSuccessful) {
                return converter.convert(response.body()!!)
            } else throw RestException(response.errorBody()!!.toString())
        } catch (exception: UnknownHostException) {
            throw Exception("UnknownHostException")
        }
    }

    override fun requestCentersForHomelessPeople(): List<Center> {
        val call = repository.getCentersForHomelessPeople()
        try {
            val response = call.execute();
            if (response.isSuccessful) {
                return converter.convert(response.body()!!)
            } else throw RestException(response.errorBody()!!.toString())
        } catch (exception: UnknownHostException) {
            throw Exception("UnknownHostException")
        }

    }

}