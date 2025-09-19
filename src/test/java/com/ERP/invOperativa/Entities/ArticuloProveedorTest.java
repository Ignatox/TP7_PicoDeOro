
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

        List<ArticuloProveedor> dbSimulada = new ArrayList<>();
        dbSimulada.add(ap);

        ArticuloProveedor apRecuperado = dbSimulada.stream()
                .filter(e -> e.getId() == 100L)
                .findFirst()
                .orElse(null);

        assertNotNull(apRecuperado);
        assertEquals(100L, apRecuperado.getId());
        assertEquals(1L, apRecuperado.getArticulo().getId());
        assertEquals(2L, apRecuperado.getProveedor().getId());
    }

}
        // Simular "guardar" en una

