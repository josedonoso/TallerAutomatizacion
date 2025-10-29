package com.prueba.tallerci;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "com.prueba.tallerci.stepdefinitions",
        // ESTA LÍNEA DEBE SER CORRECTA:
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
)
public class CucumberRunner {
    // Clase vacía
}
