package com.example.talentomobiletechtest.feature.centersfeed.data.remote

import com.example.talentomobiletechtest.feature.centersfeed.data.model.Center

interface CentersRepository {

    fun requestJuvenileAndFamilyCareCenters(): List<Center>

    fun requestCentersForHomelessPeople(): List<Center>

}