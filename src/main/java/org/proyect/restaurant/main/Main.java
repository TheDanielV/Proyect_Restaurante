package org.proyect.restaurant.main;

import org.proyect.restaurant.model.*;

public class Main {
    public static void main (String [ ] args) {

        Admin newAdmin = new Admin();
        newAdmin.registrarCliente();
        newAdmin.tommarPedido();
        newAdmin.emitirDocumentos();

    }
}
