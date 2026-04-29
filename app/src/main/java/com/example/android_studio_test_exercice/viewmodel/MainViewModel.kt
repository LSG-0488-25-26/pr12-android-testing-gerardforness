package com.example.android_studio_test_exercice.viewmodel

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel {
    // Atributs
    private val _estatSwitch: MutableLiveData<Boolean>
    val estatSwitch: LiveData<Boolean>

    private val _esVegetaria: MutableLiveData<Boolean>
    val esVegetaria: LiveData<Boolean>

    private val _esVega: MutableLiveData<Boolean>
    val esVega: LiveData<Boolean>

    private val _esCarnivor: MutableLiveData<Boolean>
    val esCarnivor: LiveData<Boolean>

    private val _triStateStatus: MutableLiveData<ToggleableState>
    val triStateStatus: LiveData<ToggleableState>

    private val _selectedOption: MutableLiveData<String>
    val selectedOption: LiveData<String>

    private val _sliderValue: MutableLiveData<Float>
    val sliderValue: LiveData<Float>

    private val _expanded: MutableLiveData<Boolean>
    val expanded: LiveData<Boolean>

    private val _selectedItem: MutableLiveData<String>
    val selectedItem: LiveData<String>

    private val _searchText: MutableLiveData<String>
    val searchText: LiveData<String>

    private val _showSnackbar: MutableLiveData<Boolean>
    val showSnackbar: LiveData<Boolean>

    private val _toggleState: MutableLiveData<Boolean>
    val toggleState: LiveData<Boolean>

    /**
     * Constructor de la classe MainViewModel
     * que inicialitza els atributs
     */
    constructor() : super() {
        _estatSwitch = MutableLiveData(true)
        estatSwitch = _estatSwitch

        _esVegetaria = MutableLiveData(false)
        esVegetaria = _esVegetaria

        _esVega = MutableLiveData(false)
        esVega = _esVega

        _esCarnivor = MutableLiveData(true)
        esCarnivor = _esCarnivor

        _triStateStatus = MutableLiveData(ToggleableState.Off)
        triStateStatus = _triStateStatus

        _selectedOption = MutableLiveData("Messi")
        selectedOption = _selectedOption

        _sliderValue = MutableLiveData(0f)
        sliderValue = _sliderValue

        _expanded = MutableLiveData(false)
        expanded = _expanded

        _selectedItem = MutableLiveData("Opció A")
        selectedItem = _selectedItem

        _searchText = MutableLiveData("")
        searchText = _searchText

        _showSnackbar = MutableLiveData(false)
        showSnackbar = _showSnackbar

        _toggleState = MutableLiveData(false)
        toggleState = _toggleState
    }

    fun toggleEstatSwitch() {
        _estatSwitch.value = !_estatSwitch.value!!
    }

    fun toggleEsVegetaria() {
        _esVegetaria.value = !_esVegetaria.value!!
    }

    fun toggleEsVega() {
        _esVega.value = !_esVega.value!!
    }

    fun toggleEsCarnivor() {
        _esCarnivor.value = !_esCarnivor.value!!
    }

    fun toggleTriStateStatus() {
        when (_triStateStatus.value) {
            ToggleableState.On -> setTriStateStatus(ToggleableState.Off)
            ToggleableState.Off -> setTriStateStatus(ToggleableState.Indeterminate)
            ToggleableState.Indeterminate -> setTriStateStatus(ToggleableState.On)
            null -> setTriStateStatus(ToggleableState.On)
        }
    }

    private fun setTriStateStatus(triState: ToggleableState) {
        _triStateStatus.value = triState
    }

    fun setSelectedOption(option: String) {
        _selectedOption.value = option
    }

    fun setSliderValue(value: Float) {
        _sliderValue.value = value
    }

    fun setExpanded(value: Boolean) {
        _expanded.value = value
    }

    fun setSelectedItem(item: String) {
        _selectedItem.value = item
    }

    fun setSearchText(text: String) {
        _searchText.value = text
    }

    fun performSearch() {
        _showSnackbar.value = !_showSnackbar.value!!
    }

    fun toggle() {
        _toggleState.value = !_toggleState.value!!
    }
}
