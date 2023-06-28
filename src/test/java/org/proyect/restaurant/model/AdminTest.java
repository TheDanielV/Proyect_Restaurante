package org.proyect.restaurant.model;

import junit.framework.TestCase;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.Assert;


import java.sql.SQLException;

public class AdminTest{
    public AdminTest(){}
@Test
    public void given_client_data_when_its_into_sistem_then_its_saved() throws SQLException {
        Admin admin = new Admin();
        String input = "1726004615\nDaniel\nVargas\nLa Magdalena\ndaniel@gmail.com\n0998811043\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);  // Redirigir la entrada estándar

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));  // Redirigir la salida estándar

        admin.registrarCliente();
        Assert.assertEquals(admin.getCliente().getNombre(),"Daniel");
    }
    @Test
    public void given_product_when_it_exists_then_accept() throws SQLException {
        Admin admin = new Admin();
        admin.ingresarProducto(3,"Salchipapa",1.00);
        Assert.assertTrue(new Producto().validarExistencia("Salchipapa",admin.getConection()));
        admin.eliminarProducto(3);
    }
}