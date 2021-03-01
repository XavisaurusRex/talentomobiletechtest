package com.example.talentomobiletechtest.feature.themes.data.remote

import com.example.talentomobiletechtest.feature.themes.data.model.Center

interface CentersRepository {

    fun requestJuvenileAndFamilyCareCenters(): List<Center>

    fun requestCentersForHomelessPeople(): List<Center>

}