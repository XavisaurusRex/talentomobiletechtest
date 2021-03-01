package com.example.talentomobiletechtest.common.dependencyinjection.app

import com.example.talentomobiletechtest.feature.themes.data.model.ApiCentersRoot
import com.example.talentomobiletechtest.feature.themes.data.model.Center
import retrofit2.Converter

class CenterListConverter : Converter<ApiCentersRoot, List<Center>> {

    override fun convert(value: ApiCentersRoot): List<Center> {
        val centers: ArrayList<Center> = arrayListOf()
        value.values.forEach {
            centers.add(Center(it.title))
        }
        return centers
    }

}
