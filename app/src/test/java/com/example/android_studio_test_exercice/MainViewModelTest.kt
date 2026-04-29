package com.example.android_studio_test_exercice

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.compose.ui.state.ToggleableState
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    // ── toggleEstatSwitch ──────────────────────────────────────────────────────

    @Test
    fun toggleEstatSwitch_deTrue_retornaFalse() {
        // L'estat inicial és true
        viewModel.toggleEstatSwitch()
        assertEquals(false, viewModel.estatSwitch.value)
    }

    @Test
    fun toggleEstatSwitch_deFalse_retornaTrue() {
        viewModel.toggleEstatSwitch() // true → false
        viewModel.toggleEstatSwitch() // false → true
        assertEquals(true, viewModel.estatSwitch.value)
    }

    // ── toggleEsVegetaria ──────────────────────────────────────────────────────

    @Test
    fun toggleEsVegetaria_deFalse_retornaTrue() {
        viewModel.toggleEsVegetaria()
        assertEquals(true, viewModel.esVegetaria.value)
    }

    @Test
    fun toggleEsVegetaria_deTrue_retornaFalse() {
        viewModel.toggleEsVegetaria() // false → true
        viewModel.toggleEsVegetaria() // true → false
        assertEquals(false, viewModel.esVegetaria.value)
    }

    // ── toggleEsVega ───────────────────────────────────────────────────────────

    @Test
    fun toggleEsVega_deFalse_retornaTrue() {
        viewModel.toggleEsVega()
        assertEquals(true, viewModel.esVega.value)
    }

    @Test
    fun toggleEsVega_deTrue_retornaFalse() {
        viewModel.toggleEsVega() // false → true
        viewModel.toggleEsVega() // true → false
        assertEquals(false, viewModel.esVega.value)
    }

    // ── toggleEsCarnivor ───────────────────────────────────────────────────────

    @Test
    fun toggleEsCarnivor_deTrue_retornaFalse() {
        // L'estat inicial és true
        viewModel.toggleEsCarnivor()
        assertEquals(false, viewModel.esCarnivor.value)
    }

    @Test
    fun toggleEsCarnivor_deFalse_retornaTrue() {
        viewModel.toggleEsCarnivor() // true → false
        viewModel.toggleEsCarnivor() // false → true
        assertEquals(true, viewModel.esCarnivor.value)
    }

    // ── toggleTriStateStatus ───────────────────────────────────────────────────

    @Test
    fun toggleTriStateStatus_deOff_retornaIndeterminate() {
        // L'estat inicial és Off
        viewModel.toggleTriStateStatus()
        assertEquals(ToggleableState.Indeterminate, viewModel.triStateStatus.value)
    }

    @Test
    fun toggleTriStateStatus_deIndeterminate_retornaOn() {
        viewModel.toggleTriStateStatus() // Off → Indeterminate
        viewModel.toggleTriStateStatus() // Indeterminate → On
        assertEquals(ToggleableState.On, viewModel.triStateStatus.value)
    }

    @Test
    fun toggleTriStateStatus_deOn_retornaOff() {
        viewModel.toggleTriStateStatus() // Off → Indeterminate
        viewModel.toggleTriStateStatus() // Indeterminate → On
        viewModel.toggleTriStateStatus() // On → Off
        assertEquals(ToggleableState.Off, viewModel.triStateStatus.value)
    }

    // ── setSelectedOption ──────────────────────────────────────────────────────

    @Test
    fun setSelectedOption_guardaLaOpcioCorrecta() {
        viewModel.setSelectedOption("Lamine Yamal")
        assertEquals("Lamine Yamal", viewModel.selectedOption.value)
    }

    @Test
    fun setSelectedOption_sobreescriuElValorAnterior() {
        viewModel.setSelectedOption("Raphina")
        viewModel.setSelectedOption("Lamine Yamal")
        assertEquals("Lamine Yamal", viewModel.selectedOption.value)
    }

    // ── setSliderValue ─────────────────────────────────────────────────────────

    @Test
    fun setSliderValue_guardaElValorCorrecte() {
        viewModel.setSliderValue(75f)
        assertEquals(75f, viewModel.sliderValue.value)
    }

    @Test
    fun setSliderValue_valorZero() {
        viewModel.setSliderValue(0f)
        assertEquals(0f, viewModel.sliderValue.value)
    }

    @Test
    fun setSliderValue_valorMaxim() {
        viewModel.setSliderValue(100f)
        assertEquals(100f, viewModel.sliderValue.value)
    }

    // ── setExpanded ────────────────────────────────────────────────────────────

    @Test
    fun setExpanded_aTrue_retornaTrue() {
        viewModel.setExpanded(true)
        assertEquals(true, viewModel.expanded.value)
    }

    @Test
    fun setExpanded_aFalse_retornaFalse() {
        viewModel.setExpanded(true)
        viewModel.setExpanded(false)
        assertEquals(false, viewModel.expanded.value)
    }

    // ── setSelectedItem ────────────────────────────────────────────────────────

    @Test
    fun setSelectedItem_guardaLaOpcioCorrecta() {
        viewModel.setSelectedItem("Opció B")
        assertEquals("Opció B", viewModel.selectedItem.value)
    }

    @Test
    fun setSelectedItem_sobreescriuElValorAnterior() {
        viewModel.setSelectedItem("Opció B")
        viewModel.setSelectedItem("Opció C")
        assertEquals("Opció C", viewModel.selectedItem.value)
    }

    // ── setSearchText ──────────────────────────────────────────────────────────

    @Test
    fun setSearchText_guardaElTextCorrecte() {
        viewModel.setSearchText("hola")
        assertEquals("hola", viewModel.searchText.value)
    }

    @Test
    fun setSearchText_textBuit() {
        viewModel.setSearchText("hola")
        viewModel.setSearchText("")
        assertEquals("", viewModel.searchText.value)
    }

    // ── performSearch ──────────────────────────────────────────────────────────

    @Test
    fun performSearch_deFalse_retornaTrue() {
        // L'estat inicial és false
        viewModel.performSearch()
        assertEquals(true, viewModel.showSnackbar.value)
    }

    @Test
    fun performSearch_deTrue_retornaFalse() {
        viewModel.performSearch() // false → true
        viewModel.performSearch() // true → false
        assertEquals(false, viewModel.showSnackbar.value)
    }

    // ── toggle ─────────────────────────────────────────────────────────────────

    @Test
    fun toggle_deFalse_retornaTrue() {
        // L'estat inicial és false
        viewModel.toggle()
        assertEquals(true, viewModel.toggleState.value)
    }

    @Test
    fun toggle_deTrue_retornaFalse() {
        viewModel.toggle() // false → true
        viewModel.toggle() // true → false
        assertEquals(false, viewModel.toggleState.value)
    }
}
