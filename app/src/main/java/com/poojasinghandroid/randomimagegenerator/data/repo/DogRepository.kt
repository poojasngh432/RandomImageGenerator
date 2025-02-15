package com.poojasinghandroid.randomimagegenerator.data.repo

import com.poojasinghandroid.randomimagegenerator.data.model.DogImageResponse
import kotlinx.coroutines.flow.Flow

interface DogRepository {
    suspend fun getRandomDogImage(): Flow<Result<DogImageResponse>>
}