package com.everis.calculadorasimples;

/**
 * Copyright (c) 2021 everis Brasil under MIT License
 * 
 * Calculadora simples que executa as quatro operações básicas
 */
public class Calculadora
{
    public double soma( double parcela1, double parcela2 )
    {
        return parcela1 + parcela2;
    }

    public double subtrai( double minuendo, double subtraendo )
    {
        return minuendo - subtraendo;
    }

    public double multiplica( double fator1, double fator2 )
    {
        return fator1 * fator2;
    }

    public double divide( double dividendo, double divisor )
    {
        return dividendo / divisor;
    }
    
    public int restoDivisaoInteira(int dividendo, int divisor)
    {
    	return dividendo % divisor;
    }
}
