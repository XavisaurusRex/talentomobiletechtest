package com.example.talentomobiletechtest.feature.details.data.remote.impl

import com.example.talentomobiletechtest.common.data.repository.RetrofitCenterDetailsRepository
import com.example.talentomobiletechtest.common.utils.RestException
import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center
import com.example.talentomobiletechtest.feature.details.data.remote.CenterDetailsRepository
import com.example.talentomobiletechtest.feature.details.data.mapper.CenterDetailsConverter
import java.net.UnknownHostException

class CenterDetailsRepositoryImpl(
    private val repository: RetrofitCenterDetailsRepository,
    private val converter: CenterDetailsConverter
) : CenterDetailsRepository {

    override fun requestCenterDetails(url: String): Center {
        val call = repository.getCenterDetails(url)
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