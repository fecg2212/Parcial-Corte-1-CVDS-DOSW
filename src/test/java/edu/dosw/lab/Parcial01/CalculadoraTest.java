package edu.dosw.lab.Parcial01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calc = new Calculadora();

    @Test
    void testSumar() {
        assertEquals(5, calc.sumar(2, 3));
        assertEquals(0, calc.sumar(-2, 2));
    }

    @Test
    void testRestar() {
        assertEquals(1, calc.restar(3, 2));
        assertEquals(-4, calc.restar(-2, 2));
    }

    @Test
    void testEsPar() {
        assertTrue(calc.esPar(4));
        assertFalse(calc.esPar(5));
    }
}

