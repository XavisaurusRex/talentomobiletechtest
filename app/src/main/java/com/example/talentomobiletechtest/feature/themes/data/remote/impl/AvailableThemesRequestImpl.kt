package cat.devsofthecoast.vectortechincaltest.feature.userlist.data.remote.impl

import com.example.talentomobiletechtest.feature.themes.data.remote.AvailableThemesRequest
import com.example.talentomobiletechtest.common.data.repository.MadridThemesRepository
import com.example.talentomobiletechtest.common.domain.ResponseWrapper
import com.example.talentomobiletechtest.feature.themes.data.model.ApiThemesRoot
import retrofit2.Response

class AvailableThemesRequestImpl(
    private val repository: MadridThemesRepository
) : AvailableThemesRequest {

    override suspend fun getAvailableThemes(): ResponseWrapper<ApiThemesRoot> {
        val response: Response<ApiThemesRoot> = repository.requestAvailableThemes()
        return if (response.isSuccessful)
            ResponseWrapper.Success(
                response.body()!!
            ) else ResponseWrapper.Error()
    }

}