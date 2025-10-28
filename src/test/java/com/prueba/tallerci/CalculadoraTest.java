package com.prueba.tallerci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    
    
    
    private final Calculadora calc = new Calculadora();
    
    @Test
    void testSumarCorrecto(){
        assertEquals(5, calc.sumar(3, 2),"La suma de 3+2 debe dar 5"); 
    }
    @Test
    void testRestaCorrecta(){
        assertEquals(1, calc.restar(4, 3), "La resta de 4 -3 debe dar 1");
    }
}
