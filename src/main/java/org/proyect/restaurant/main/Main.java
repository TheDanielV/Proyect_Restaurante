package org.proyect.restaurant.main;

import org.proyect.restaurant.model.*;

import java.sql.SQLException;

public class Main {
    public static void main (String [ ] args) throws SQLException {

        Admin newAdmin = new Admin();
        newAdmin.registrarCliente();
        newAdmin.tommarPedido();
        newAdmin.emitirDocumentos();

    }
}
