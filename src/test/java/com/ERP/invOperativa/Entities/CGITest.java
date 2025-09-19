package com.ERP.invOperativa.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CGITest {

    //1. Probar que la clase CGI se pueda instanciar correctamente:
    @Test
    public void testConstructorCGI() {
        // Intenta crear una instancia
        CGI cgi = new CGI();
        assertNotNull(cgi);
    }

    //2. Verificar que la función calcularCGI de la clase CGI funcione correctamente:
    @Test
    void testCalcularCGI() {
        // Datos de entrada
        double costoCompra = 50.0;
        double costoMantenimiento = 5.0;
        double costoPedido = 100.0;
        int cantidadPedido = 200;
        int demandaAnual = 1000;

        // Cálculo esperado:
        // costoTotalPedido = (100 * 1000) / 200 = 500
        // costoTotalCompra = 50 * 1000 = 50000
        // costoTotalMantenimiento = (5 * 200) / 2 = 500
        // total = 500 + 50000 + 500 = 51000
        double esperado = 51000.0;

        double resultado = CGI.calcularCGI(costoCompra, costoMantenimiento, costoPedido, cantidadPedido, demandaAnual);

        assertEquals(esperado, resultado, 0.0001); // delta para flotantes
    }

    //prueba de regrecion apartir de modificacion de la prueba unitaria 2
    
    @Test
    void testCalcularCGI_regresion() {
        // Datos de entrada históricos (no deben cambiar)
        double costoCompra = 50.0;
        double costoMantenimiento = 5.0;
        double costoPedido = 100.0;
        int cantidadPedido = 200;
        //cambie este valor para que falle la prueba
        int demandaAnual = 1000000;

        // Valor esperado calculado y validado previamente
        double esperado = 51000.0;

        double resultado = CGI.calcularCGI(costoCompra, costoMantenimiento, costoPedido, cantidadPedido, demandaAnual);

        // como el valor de resultado cambio , porque la lógica fue modificada por lo tanto la prueba falla
        // y se alerta de una posible regresion
        assertEquals(esperado, resultado, 0.0001, "El cálculo de CGI ha cambiado. Posible regresión.");
    }
}
