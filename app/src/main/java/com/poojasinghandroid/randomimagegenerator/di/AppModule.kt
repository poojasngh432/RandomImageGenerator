package com.poojasinghandroid.randomimagegenerator.di

import com.poojasinghandroid.randomimagegenerator.data.remote.DogApiService
import com.poojasinghandroid.randomimagegenerator.data.repo.DogRepository
import com.poojasinghandroid.randomimagegenerator.data.repo.DogRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideDogApiService(retrofit: Retrofit): DogApiService =
        retrofit.create(DogApiService::class.java)

    @Provides
    @Singleton
    fun provideDogRepository(apiService: DogApiService): DogRepository =
        DogRepositoryImpl(apiService)
}