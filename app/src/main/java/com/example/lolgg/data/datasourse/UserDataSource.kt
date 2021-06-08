package com.example.lolgg.data.datasourse

import com.example.lolgg.data.api.RiotApiService
import com.example.lolgg.data.models.response.UserResponse
import com.example.lolgg.domain.models.UserResponseErrorHandle.*
import retrofit2.HttpException
import java.net.UnknownHostException

class UserDataSource(private val service: RiotApiService) {

    suspend fun getSummonerInfoTest(name: String): UserResponse {
        return try {
            service.getSummonerInfoTest(name)
        }
        catch(t:Throwable) {
            throw when(t){
                is HttpException -> throw when(t.code()){
                    401 -> ApiUnauthorized
                    403 -> ApiForbidden
                    404 -> ApiDataNotFound
                    503 -> ApiServiceUnavailable
                    504 -> ApiGatewayTimeOut
                    else -> ApiDeveloperProblem
                }
                is UnknownHostException -> InternetError
                else -> ApiDeveloperProblem
            }
        }
    }
}