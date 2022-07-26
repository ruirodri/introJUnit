package com.everis.calculadorasimples;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Copyright (c) 2021 everis Brasil under MIT License
 * 
 * Testes unitários para a classe Calculadora da package calculadorasimples
 * 
 * Observem que não estamos nem perto de ter uma cobertura de testes adequada
 * com estes exemplos abaixo. O nosso objetivo aqui é ilustrar a utilização do
 * JUnit, e buscamos fazer os testes suficientes para isto.
 */
public class CalculadoraTest {
    static Calculadora calculadora;

    @Test
    public void testaSomaMenosIngenuo() {
        Calculadora myCalc = new Calculadora();

        boolean temErro = false;
        if (myCalc.soma(2, 2) != 4) {
            temErro = true;
        }
        if (myCalc.soma(2, -2) != 0) {
            temErro = true;
        }
        if (myCalc.soma(-2, 2) != 0) {
            temErro = true;
        }
        if (myCalc.soma(-2, -2) != -4) {
            temErro = true;
        }
        if (myCalc.soma(0, 0) != 0) {
            temErro = true;
        }
        if (temErro) {
            fail("Houve um erro na validação da soma.");
        }
    }

    @Test
    public void deveResultarQuatroAoSomarDoisEDois() {
        // Calculadora calculadora = new Calculadora();
        assertEquals(4.0, calculadora.soma(2, 2));
    }

    @Test
    public void deveResultarZeroAoSomarDoisEMenosDois() {
        // Calculadora calculadora = new Calculadora();
        assertEquals(0.0, calculadora.soma(2, -2));
    }

    @BeforeAll
    public static void setup() {
        calculadora = new Calculadora();
    }
    // Outros: @BeforeEach, @AfterEach, @AfterAll

    @DisplayName("Valida múltiplas somas com informações em CSV")
    @ParameterizedTest
    @CsvSource({ "1.0, 1.0, 2.0", "2.0, 3.0, 5.0", "3.0, 4.0, 7.0", "4.0, 4.0, 8.0" })
    void validaMultiplasSomasCSV(double parcela1, double parcela2, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.soma(parcela1, parcela2));
    }

    @DisplayName("Valida múltiplas somas com informações em arquivo CSV")
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void validaMultiplasSomasArqCSV(double parcela1, double parcela2, double resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.soma(parcela1, parcela2));
    }

    @Test
    public void divisaoPorZeroGeraExcecao() {
        assertThrows(ArithmeticException.class, () -> {
        	int resultado = calculadora.restoDivisaoInteira(4, 0);
            System.out.println(resultado);
        });
    }

}
