package com.poojasinghandroid.randomimagegenerator.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poojasinghandroid.randomimagegenerator.data.local.LRUCache
import com.poojasinghandroid.randomimagegenerator.data.repo.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogViewModel @Inject constructor(
    private val repository: DogRepository,
    private val cache: LRUCache
): ViewModel() {
    private val _dogImage = MutableStateFlow<String?>(null)
    val dogImage: StateFlow<String?> = _dogImage

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    private val _cachedDogImages = MutableStateFlow<List<String>>(emptyList())
    val cachedDogImages: StateFlow<List<String>> = _cachedDogImages

    init {
        loadCachedDogImages()
    }

    fun generateDogImage() {
        viewModelScope.launch {
            repository.getRandomDogImage().collect { result ->
                result.onSuccess {
                    cache.put(it.message)
                    _dogImage.value = it.message
                    loadCachedDogImages()
                }.onFailure {
                    _error.value = it.message
                }
            }
        }
    }

    private fun loadCachedDogImages() {
        _cachedDogImages.value = cache.getRecentDogImages()
    }

    fun clearCache() {
        viewModelScope.launch {
            cache.clear()
            _cachedDogImages.value = emptyList()
        }
    }
}