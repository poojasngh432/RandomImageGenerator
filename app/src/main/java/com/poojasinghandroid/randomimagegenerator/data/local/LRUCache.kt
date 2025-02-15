package com.poojasinghandroid.randomimagegenerator.data.local

import android.content.Context
import androidx.collection.LruCache
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "dog_images_store")

@Singleton
class LRUCache @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val cache = LruCache<Int, String>(20)
    private val DOG_IMAGES_KEY = stringSetPreferencesKey("dog_images_list")

    init {
        loadCachedImages()
    }

    fun put(url: String) {
        val key = System.currentTimeMillis().toInt()
        cache.put(key, url)
        saveImagesToDataStore()
    }

    fun getRecentDogImages(): List<String> {
        return cache.snapshot().values.toList()
    }

    fun clear() {
        cache.evictAll()
    }

    private fun saveImagesToDataStore() {
        val imagesList = getRecentDogImages().toSet()
        runBlocking {
            context.dataStore.edit { settings ->
                settings[DOG_IMAGES_KEY] = imagesList
            }
        }
    }

    private fun loadCachedImages() {
        runBlocking {
            val storedImages = context.dataStore.data.first()[DOG_IMAGES_KEY] ?: emptySet()
            storedImages.forEach { put(it) }
        }
    }
}