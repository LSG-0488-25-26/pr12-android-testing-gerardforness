package com.example.android_studio_test_exercice

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainViewUITest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    // ── Switch ────────────────────────────────────────────────────────────────

    @Test
    fun switch_estatInicialActivat() {
        composeTestRule.onNodeWithTag("switch_id").assertIsOn()
    }

    @Test
    fun switch_alFerClick_esDesactiva() {
        composeTestRule.onNodeWithTag("switch_id").performClick()
        composeTestRule.onNodeWithTag("switch_id").assertIsOff()
    }

    // ── Checkbox Carnívor ─────────────────────────────────────────────────────

    @Test
    fun checkboxCarnivor_estatInicialActivat() {
        composeTestRule.onNodeWithTag("checkboxCarnivor_id").assertIsOn()
    }

    @Test
    fun checkboxCarnivor_estaDesactivat() {
        composeTestRule.onNodeWithTag("checkboxCarnivor_id").assertIsNotEnabled()
    }

    // ── Checkbox Vegetarià ────────────────────────────────────────────────────

    @Test
    fun checkboxVegetaria_estatInicialDesactivat() {
        composeTestRule.onNodeWithTag("checkboxVegetaria_id").assertIsOff()
    }

    @Test
    fun checkboxVegetaria_alFerClick_sActiva() {
        composeTestRule.onNodeWithTag("checkboxVegetaria_id").performClick()
        composeTestRule.onNodeWithTag("checkboxVegetaria_id").assertIsOn()
    }

    // ── Checkbox Vegà ─────────────────────────────────────────────────────────

    @Test
    fun checkboxVega_estatInicialDesactivat() {
        composeTestRule.onNodeWithTag("checkboxVega_id").assertIsOff()
    }

    @Test
    fun checkboxVega_alFerClick_sActiva() {
        composeTestRule.onNodeWithTag("checkboxVega_id").performClick()
        composeTestRule.onNodeWithTag("checkboxVega_id").assertIsOn()
    }

    // ── TriStateCheckbox ──────────────────────────────────────────────────────

    @Test
    fun triStateCheckbox_estatInicialOff() {
        composeTestRule.onNodeWithTag("triStateCheckbox_id").assertIsOff()
    }

    @Test
    fun triStateCheckbox_dosClicks_estatOn() {
        composeTestRule.onNodeWithTag("triStateCheckbox_id").performClick() // Off → Indeterminate
        composeTestRule.onNodeWithTag("triStateCheckbox_id").performClick() // Indeterminate → On
        composeTestRule.onNodeWithTag("triStateCheckbox_id").assertIsOn()
    }

    @Test
    fun triStateCheckbox_tresClicks_tornaAOff() {
        composeTestRule.onNodeWithTag("triStateCheckbox_id").performClick() // Off → Indeterminate
        composeTestRule.onNodeWithTag("triStateCheckbox_id").performClick() // Indeterminate → On
        composeTestRule.onNodeWithTag("triStateCheckbox_id").performClick() // On → Off
        composeTestRule.onNodeWithTag("triStateCheckbox_id").assertIsOff()
    }

    // ── RadioButtons ──────────────────────────────────────────────────────────

    @Test
    fun radioVinicius_estaDesactivat() {
        composeTestRule.onNodeWithTag("radio_Vinicius_id").assertIsNotEnabled()
    }

    @Test
    fun radioLamineYamal_alFerClick_seleccionat() {
        composeTestRule.onNodeWithTag("radio_LamineYamal_id").performClick()
        composeTestRule.onNodeWithTag("radio_LamineYamal_id").assertIsSelected()
    }

    @Test
    fun radioRaphina_alFerClick_seleccionat() {
        composeTestRule.onNodeWithTag("radio_Raphina_id").performClick()
        composeTestRule.onNodeWithTag("radio_Raphina_id").assertIsSelected()
    }

    // ── Slider ────────────────────────────────────────────────────────────────

    @Test
    fun volumText_valorInicial() {
        composeTestRule.onNodeWithTag("volumText_id").assertTextEquals("Volum: 0%")
    }

    @Test
    fun slider_existeix() {
        composeTestRule.onNodeWithTag("slider_id").assertExists()
    }

    // ── Dropdown ──────────────────────────────────────────────────────────────

    @Test
    fun dropdown_opcioInicialOpcioA() {
        composeTestRule.onNodeWithTag("dropdownText_id").assertTextEquals("Opció A")
    }

    @Test
    fun dropdown_alFerClick_mostraLesOpcions() {
        composeTestRule.onNodeWithTag("dropdownText_id").performClick()
        composeTestRule.onNodeWithText("Opció B").assertIsDisplayed()
        composeTestRule.onNodeWithText("Opció C").assertIsDisplayed()
    }

    @Test
    fun dropdown_alSeleccionarOpcioB_actualitzaText() {
        composeTestRule.onNodeWithTag("dropdownText_id").performClick()
        composeTestRule.onNodeWithText("Opció B").performClick()
        composeTestRule.onNodeWithTag("dropdownText_id").assertTextEquals("Opció B")
    }

    // ── OutlinedTextField ─────────────────────────────────────────────────────

    @Test
    fun searchTextField_existeix() {
        composeTestRule.onNodeWithTag("searchTextField_id").assertExists()
    }

    @Test
    fun searchTextField_alEscriureText_actualitzaValor() {
        composeTestRule.onNodeWithTag("searchTextField_id").performTextInput("hola")
        composeTestRule.onNodeWithTag("searchTextField_id").assertTextContains("hola")
    }

    // ── Botó Buscar ───────────────────────────────────────────────────────────

    @Test
    fun botoBuscar_existeix() {
        composeTestRule.onNodeWithTag("buscarButton_id").assertExists()
    }

    @Test
    fun botoBuscar_alFerClick_mostraSnackbar() {
        composeTestRule.onNodeWithTag("buscarButton_id").performClick()
        composeTestRule.onNodeWithTag("snackbarText_id").assertExists()
    }

    // ── Snackbar ──────────────────────────────────────────────────────────────

    @Test
    fun snackbar_noExisteixInialment() {
        composeTestRule.onNodeWithTag("snackbarText_id").assertDoesNotExist()
    }

    // ── Botó Toggle ───────────────────────────────────────────────────────────

    @Test
    fun botoToggle_textInicialDesactivat() {
        composeTestRule.onNodeWithTag("toggleButton_id").assertTextContains("Desactivat")
    }

    @Test
    fun botoToggle_alFerClick_mostraActivat() {
        composeTestRule.onNodeWithTag("toggleButton_id").performClick()
        composeTestRule.onNodeWithTag("toggleButton_id").assertTextContains("Activat")
    }
}
