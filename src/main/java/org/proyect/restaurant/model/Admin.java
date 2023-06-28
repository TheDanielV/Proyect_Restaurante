package org.proyect.restaurant.model;


import java.sql.SQLException;
import java.util.Scanner;
import org.proyect.restaurant.conection.*;

public class Admin {
    private Cliente cliente;
    private final Pedido pedido = new Pedido();
    private final Producto producto = new Producto();
    private final OrdenPedidos orden = new OrdenPedidos();
    private final DbConection conection = new DbConection();

    public Admin() {
        conection.begginConection();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public DbConection getConection() {
        return conection;
    }

    public void registrarCliente() throws SQLException {
        Cliente client = new Cliente();
        String id = "";
        String nombre, apellido;
        String direccion, correo, telefono;
        //Registro del número de cédula

        boolean flag = true;
        while (flag) {
            System.out.print("Número de cédula: ");
            Scanner cedulaIn = new Scanner(System.in);
            id = cedulaIn.nextLine();
            // verificar el nombre ingresado
            if (Validacion.validarCedula(id)) {
                flag = false;
            } else {
                System.out.println("Su número de cedula esta incorecto");
            }
        }
        if (conection.existecliente(id))  {
                //Registramos al nuevo cliente
                client.setCedula(id);
            // Registro del nombre, validación de esste
            flag = true;
            while (flag) {
                System.out.print("Nombre del Cliente: ");
                Scanner nombreIn = new Scanner(System.in);
                nombre = nombreIn.nextLine();
                // verificar el nombre ingresado
                if (Validacion.validarNombre(nombre)) {
                    client.setNombre(nombre);
                    flag = false;
                } else {
                    System.out.println("Su nombre no puede contener números ni caracteres especiales");
                }
            }
            flag = true;
            // Registro del apellido del cliente
            while (flag) {
                System.out.print("Apellido del Cliente: ");
                Scanner entradaApellido = new Scanner(System.in);
                apellido = entradaApellido.nextLine();
                // Verificación de el apellido, si es ingresado correctamente
                if (Validacion.validarApellido(apellido)) {
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
                if (Validacion.validarDireccion(direccion)) {
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
                if (Validacion.validarCorreoElectronico(correo)) {
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
                if (Validacion.validarTelefono(telefono)) {
                    client.setTelefono(telefono);
                    flag = false;
                } else {
                    System.out.println("Número de teléfono inválido, vuelva a ingresarlo");
                }
            }

            System.out.println("\n");

            this.cliente = client;

            conection.registroCliente(cliente);
        }else {

            this.cliente = conection.getCliente(id);
        }
    }




    public void emitirDocumentos(){
        Factura factur = new Factura(cliente, pedido);
        factur.emitirFactura();
        orden.emitirOrden(pedido);

    }
    public void tommarPedido() throws SQLException {

        boolean flag = true;
        while (flag) {
            System.out.print("Ingrese el producto: ");
            Scanner in = new Scanner(System.in);
            String product = in.nextLine();
            System.out.print("Ingrese la Cantidad: ");
            Scanner inCantidad = new Scanner(System.in);
            int cantidad = inCantidad.nextInt();

            // verificar el nombre ingresado
            if (pedido.agregarPedido(product,cantidad, conection, cliente.getCedula())){
                System.out.print("Agregar otro prodducto? s/n");
                if (in.nextLine().equals("s")){

                }else{
                    flag = false;
                    pedido.setId(conection.getPedidoId()+1);
                    System.out.print("Ingresar la mesa del pedido: ");  //************************** Aqui se ingresa en numero de mesa***********************************************/
                    pedido.setmesa(in.nextInt());
                    conection.registroPedido(pedido);
                }
            }else{
                System.out.print("El producto no existe, ingrese otro ");
            }
        }
    }
    public void ingresarProducto(int id, String nombre, double precio){
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        conection.registroProducto(producto);
    }

    public void eliminarProducto(int i) {
        conection.removeProducto(i);
    }
}
