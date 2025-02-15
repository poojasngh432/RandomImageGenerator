package com.poojasinghandroid.randomimagegenerator.data.remote

import com.poojasinghandroid.randomimagegenerator.data.model.DogImageResponse
import retrofit2.http.GET

interface DogApiService {
    @GET("breeds/image/random")
    suspend fun getRandomDogImage(): DogImageResponse
}