package com.poojasinghandroid.randomimagegenerator.data.repo

import coil3.network.HttpException
import com.poojasinghandroid.randomimagegenerator.data.model.DogImageResponse
import com.poojasinghandroid.randomimagegenerator.data.remote.DogApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class DogRepositoryImpl @Inject constructor(
    private val apiService: DogApiService
) : DogRepository {
    override suspend fun getRandomDogImage(): Flow<Result<DogImageResponse>> = flow {
        try {
            val response = apiService.getRandomDogImage()
            if(response.status == STATUS) {
                emit(Result.success(response))
            } else {
                emit(Result.failure(Exception("Data unavailable")))
            }
        } catch (e: HttpException) {
            emit(Result.failure(Exception("Network error: ${e.message}")))
        } catch (e: IOException) {
            emit(Result.failure(Exception("Check your internet connection")))
        }
    }

    companion object {
        const val STATUS = "success"
    }
}