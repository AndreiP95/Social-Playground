package ro.andreip.socialplayground.demoScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DemoViewModel {

    private val _firstButtonEnabled = MutableLiveData(true)
    val firstButtonEnabled: LiveData<Boolean> = _firstButtonEnabled

    private val _secondButtonEnabled = MutableLiveData(false)
    val secondButtonEnabled: LiveData<Boolean> = _secondButtonEnabled


    fun firstButtonClicked() {
        _firstButtonEnabled.value = false
        _secondButtonEnabled.value = true
    }

    fun secondButtonClicked() {
        _firstButtonEnabled.value = true
        _secondButtonEnabled.value = false
    }
}