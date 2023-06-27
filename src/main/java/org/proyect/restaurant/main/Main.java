package org.proyect.restaurant.main;

import org.proyect.restaurant.model.*;

import java.sql.SQLException;

public class Main {
    public static void main (String [ ] args) throws SQLException {

        Admin newAdmin = new Admin();
        //newAdmin.ingresarProducto(002,"Hamburguesa Completa",4.00);
        newAdmin.registrarCliente();
        newAdmin.tommarPedido();
        newAdmin.emitirDocumentos();

    }
}
