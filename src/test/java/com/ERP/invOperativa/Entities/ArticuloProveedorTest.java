
package com.ERP.invOperativa.Entities;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArticuloProveedorTest {

    // //7. probar que la clase ArticuloProveedor se pueda instanciar correctamente:
    @Test
    public void testInstanciarArticuloProveedor() {
        // Crear instancias de Articulo y Proveedor
        Articulo articulo = new Articulo();
        articulo.setId(1L);

        Proveedor proveedor = new Proveedor();
        proveedor.setId(2L);

        // Crear ArticuloProveedor
        ArticuloProveedor ap = new ArticuloProveedor();
        ap.setArticulo(articulo);
        ap.setProveedor(proveedor);
        ap.setId(100L); // si tiene ID

        // Verificar que se guardaron correctamente
        assertEquals(100L, ap.getId());
        assertEquals(1L, ap.getArticulo().getId());
        assertEquals(2L, ap.getProveedor().getId());
    }

    // 2Prueba de integración simulada
    @Test
    public void testArticuloProveedorIntegracionSimulada() {
        // Crear entidades
        Articulo articulo = new Articulo();
        articulo.setId(1L);

        Proveedor proveedor = new Proveedor();
        proveedor.setId(2L);

        // Crear relación ArticuloProveedor
        ArticuloProveedor ap = new ArticuloProveedor();
        ap.setArticulo(articulo);
        ap.setProveedor(proveedor);
        ap.setId(100L);


// Simular "guardar" en una lista como si fuera la DB
        List<ArticuloProveedor> dbSimulada = new ArrayList<>();
        dbSimulada.add(ap);

        // Recuperar de la lista simulada

        ArticuloProveedor apRecuperado = dbSimulada.stream()
                .filter(e -> e.getId() == 100L)
                .findFirst()
                .orElse(null);

        assertNotNull(apRecuperado);
        assertEquals(100L, apRecuperado.getId());
        assertEquals(1L, apRecuperado.getArticulo().getId());
        assertEquals(2L, apRecuperado.getProveedor().getId());
    }
    //validar que el precio no se pierda ni cambie a 0
    //000
    @Test
    public void testPrecioArticuloProveedorNoSePierdeAlGuardar() {
        // Crear un ArticuloProveedor con precio inicial
        ArticuloProveedor ap = new ArticuloProveedor();
        ap.setId(200L);
        ap.setPrecioArticuloProveedor(150.75);

        // Simular una "base de datos"
        List<ArticuloProveedor> dbSimulada = new ArrayList<>();
        dbSimulada.add(ap);

        // Recuperar de la lista
        ArticuloProveedor apRecuperado = dbSimulada.stream()
                .filter(e -> e.getId() == 200L)
                .findFirst()
                .orElse(null);

    // Validar que el precio no cambió a 0
        assertNotNull(apRecuperado);
        assertEquals(150.75, apRecuperado.getPrecioArticuloProveedor(), 0.001,
                "El precio debería mantenerse y no resetearse a 0");
    }


    
}

