package com.prueba.tallerci;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Le dice a Cucumber dónde encontrar los archivos .feature
        features = "src/test/resources/features", 
        // Le dice dónde encontrar las clases de Step Definitions
        glue = "com.prueba.tallerci.stepdefinitions", 
        // Genera un reporte HTML navegable
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
        // Muestra el nombre real de los escenarios en lugar del nombre del método
        
)

public class CucumberRunner {
    
}
