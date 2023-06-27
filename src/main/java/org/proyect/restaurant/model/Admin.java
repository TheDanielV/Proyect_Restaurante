package org.proyect.restaurant.model;


import java.sql.SQLException;
import java.util.Scanner;
import org.proyect.restaurant.conection.*;

public class Admin {
    Cliente cliente;
    Pedido pedido = new Pedido();
    Factura factur;
    Validacion validador;
    DbConection conection = new DbConection();

    public Admin() {
        conection.begginConection();
    }

    public void setClient(Cliente client) {
        this.cliente = client;
    }


    public void registrarCliente() throws SQLException {
        Cliente client = new Cliente();
        String id = "";
        String nombre = "", apellido = "";
        String direccion = "", correo = "", telefono = "";
        //Registro del número de cédula

        boolean flag = true;
        while (flag) {
            System.out.print("Número de cédula: ");
            Scanner cedulaIn = new Scanner(System.in);
            id = cedulaIn.nextLine();
            // verificar el nombre ingresado
            if (validador.validarCedula(id)) {
                client.setCedula(id);
                flag = false;
            } else {
                System.out.println("Su número de cedula esta incorecto");
            }
        }

        // Registro del nombre, validación de esste
         flag = true;
        while (flag) {
            System.out.print("Nombre del Cliente: ");
            Scanner nombreIn = new Scanner(System.in);
            nombre = nombreIn.nextLine();
            // verificar el nombre ingresado
            if (validador.validarNombre(nombre)) {
                client.setNombre(nombre);
                flag = false;
            } else {
                System.out.println("Su nombre no puede contener números ni caracteres especiales");
            }
        }
        flag = true;
        // Registro del apellido del cliente
        while (flag) {
            System.out.print("Apellido del empleado: ");
            Scanner entradaApellido = new Scanner(System.in);
            apellido = entradaApellido.nextLine();
            // Verificación de el apellido, si es ingresado correctamente
            if (validador.validarApellido(apellido)) {
                client.setApellido(apellido);
                flag = false;
            } else {
                System.out.println("Su apellido no puede contener números ni caracteres especiales");
            }
        }

        flag = true;

        // Registrar Dirección
        while (flag) {
            System.out.print("Dirección del cliente: ");
            Scanner entradaDireccion = new Scanner(System.in);
            direccion = entradaDireccion.nextLine();
        //Validación de la dirección del cliente
            if (validador.validarDireccion(direccion)) {
                client.setDireccion(direccion);
                flag = false;
            } else {
                System.out.println("Su direccion no puede contener caracteres especiales");
            }
        }
        flag = true;
        // Registro del correo Electronico
        while (flag) {
            System.out.print("Correo Electrónico del cliente: ");
            Scanner entradaCorreo = new Scanner(System.in);
            correo = entradaCorreo.nextLine();
            //Validación del correo electrónico
            if (validador.validarCorreoElectronico(correo)) {
                client.setCorreo(correo);
                flag = false;
            } else {
                System.out.println("Correo inválido, vuelva a ingresarlo");
            }
        }
        flag = true;
        // Registrar telefono del cliente
        while (flag) {
            System.out.print("Número de teléfono del cliente: ");
            Scanner entradaTelefono = new Scanner(System.in);
            telefono = entradaTelefono.nextLine();
            //Validar teléfono del cliente
            if (validador.validarTelefono(telefono)) {
                client.setTelefono(telefono);
                flag = false;
            } else {
                System.out.println("Número de teléfono inválido, vuelva a ingresarlo");
            }
        }

        System.out.println("\n");

        this.cliente = client;

        conection.registroCliente(cliente);
       /* File fichero = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        String cadena = "";
        try {
            fichero = new File("registroEmpleados2.txt");
            fw = new FileWriter(fichero, true);
            pw = new PrintWriter(fw);
            cadena += client.getCedula() + ",";
            cadena += client.getNombre() + ",";
            cadena += client.getApellido() + ",";
            cadena += client.getDireccion() + ",";
            cadena += client.getCorreo() + ",";
            cadena += client.getTelefono();
            String cadena2 = cadena;
            pw.println(cadena2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }



    public Cliente getClient() {
        return cliente;
    }

    public void emitirDocumentos(){
        factur = new Factura(cliente, pedido);
        factur.emitirFactura();

    }
    public void tommarPedido(){

        boolean flag = true;
        while (flag) {
            System.out.print("Ingrese el producto: ");
            Scanner in = new Scanner(System.in);
            String product = in.nextLine();

            // verificar el nombre ingresado
            if (pedido.agregarPedido(product,1)){
                System.out.print("Agregar otro prodducto? s/n");
                if (in.nextLine().equals("s")){
                }else{
                    flag = false;
                }
            }else{
                System.out.print("El producto no existe, ingrese otro ");
            }
        }
    }
}
