package me.r4bt.time_killer_app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.cancel

class MainViewModel : ViewModel() {
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    init {
        _count.value = 0
    }

    private fun getCount(): Int {
        return _count.value ?: 0
    }

    fun incrementCounter() {
        val currentValue = getCount()
        _count.value = currentValue + 1
    }

    override fun onCleared() {
        super.onCleared()
        // Cancel all coroutines when the ViewModel is cleared
        viewModelScope.cancel()
    }
}