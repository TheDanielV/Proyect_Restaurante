package org.proyect.restaurant.conection;
import org.proyect.restaurant.model.*;

import java.sql.*;

public class DbConection {
    Connection connection = null;
    public DbConection() {
    }
    public void begginConection(){

        try {
            String url = "jdbc:mysql://localhost:3306/bdrestaurante";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
    public void registroCliente(Cliente cliente) throws SQLException {
        String consulta = "INSERT INTO cliente (cedula,Nombre,Apellido,Direccion,Correo,Telefono) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            // Establecer los valores de los parámetros
            preparedStatement.setString(1, cliente.getCedula());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setString(5, cliente.getCorreo());
            preparedStatement.setString(6, cliente.getTelefono());

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            System.out.println("Cliente registraado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al Registrar al cliente: " + e.getMessage());
        }
    }
    public void registroProducto(Producto producto){
        String consulta = "INSERT INTO producto (cedula,Nombre,Apellido,Direccion,Correo,Telefono) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            // Establecer los valores de los parámetros
            preparedStatement.setString(1, producto.getCedula());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setString(3, producto.getApellido());
            preparedStatement.setString(4, producto.getDireccion());
            preparedStatement.setString(5, producto.getCorreo());
            preparedStatement.setString(6, producto.getTelefono());

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            System.out.println("Producto ingresado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al ingresar el Producto: " + e.getMessage());
        }
    }
    public void finishConection() throws SQLException {
        connection.close();
    }
}

