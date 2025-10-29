package com.prueba.tallerci.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert; // Usamos el Assert de JUnit para las verificaciones.

public class LoginSteps {

    // --- Variables de Estado (Simulación de la Aplicación) ---
    private boolean isSystemAvailable;
    private boolean loginSuccessful;
    private String actualErrorMessage;
    
    // Credenciales válidas simuladas
    private final String VALID_USER = "test@company.com";
    private final String VALID_PASS = "PassWordSeguro";
    private final String EXPECTED_ERROR = "Credenciales inválidas. Por favor, intente de nuevo.";
    // --------------------------------------------------------

    // --- PASOS GIVEN ---

    @Given("el usuario {string} está registrado y activo")
    public void el_usuario_está_registrado_y_activo(String correo) {
        // Tarea T38: Simulación de la condición inicial del test atómico.
        // Verificamos que el usuario de prueba sea el correcto.
        Assert.assertTrue("Precondición fallida: El usuario no es el usuario de prueba esperado.", correo.equals(VALID_USER));
        this.isSystemAvailable = true;
        this.loginSuccessful = false; // Reiniciar estado
    }

    @Given("el sistema de login está disponible")
    public void el_sistema_de_login_está_disponible() {
        // Tarea T38: Simulación de la disponibilidad del servicio.
        this.isSystemAvailable = true;
        this.loginSuccessful = false; // Reiniciar estado
        this.actualErrorMessage = null;
    }


    // --- PASO WHEN (Usado en todos los escenarios) ---

    @When("el usuario intenta iniciar sesión con correo {string} y contraseña {string}")
    public void el_usuario_intenta_iniciar_sesión_con_correo_y_contraseña(String correo, String contrasena) {
        // Tarea T38: Simulación de la lógica de login
        if (correo.equals(VALID_USER) && contrasena.equals(VALID_PASS)) {
            this.loginSuccessful = true;
            this.actualErrorMessage = null;
        } else {
            this.loginSuccessful = false;
            this.actualErrorMessage = EXPECTED_ERROR;
        }
    }


    // --- PASOS THEN (Verificaciones de Resultado) ---

    @Then("el inicio de sesión debe ser exitoso")
    public void el_inicio_de_sesión_debe_ser_exitoso() {
        // Verificación de éxito.
        Assert.assertTrue("El inicio de sesión falló inesperadamente.", this.loginSuccessful);
    }

    @Then("el usuario es redirigido al dashboard")
    public void el_usuario_es_redirigido_al_dashboard() {
        // Verificación de la post-condición de éxito.
        Assert.assertTrue("No se cumplió la post-condición de redirección (Simulado).", this.loginSuccessful);
    }

    @Then("el inicio de sesión debe fallar")
    public void el_inicio_de_sesión_debe_fallar() {
        // Verificación de fallo.
        Assert.assertFalse("El inicio de sesión fue exitoso cuando se esperó fallo.", this.loginSuccessful);
    }

    @Then("debe mostrar el mensaje de error {string}")
    public void debe_mostrar_el_mensaje_de_error(String expectedErrorMessage) {
        // Verificación del mensaje de error
        Assert.assertFalse("El inicio de sesión no debió ser exitoso.", this.loginSuccessful);
        Assert.assertEquals("El mensaje de error no coincide.", expectedErrorMessage, this.actualErrorMessage);
    }
}