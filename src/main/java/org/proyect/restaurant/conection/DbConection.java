package org.proyect.restaurant.conection;
import org.proyect.restaurant.model.*;

import java.sql.*;

public class DbConection {
    Connection connection = null;
    public DbConection() {
    }
    public void begginConection(){

        try {
            String url = "jdbc:mysql://sql10.freemysqlhosting.net:3306/sql10629153";
            String username = "sql10629153";
            String password = "SsFJQf3cqH";
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
    public Cliente getCliente(String cedula){
        Cliente cliente = new Cliente();

        String consulta = "SELECT Nombre, Apellido, Direccion, Correo,Telefono FROM cliente WHERE cedula = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setString(1, cedula);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String nombre = resultSet.getString("Nombre");
                    String apellido = resultSet.getString("Apellido");
                    String direccion = resultSet.getString("Direccion");
                    String correo = resultSet.getString("Correo");
                    String telefono = resultSet.getString("Telefono");

                    // Crear un objeto Cliente y asignar los valores

                    cliente.setCedula(cedula);
                    cliente.setNombre(nombre);
                    cliente.setApellido(apellido);
                    cliente.setDireccion(direccion);
                    cliente.setCorreo(correo);
                    cliente.setTelefono(telefono);

                } else {
                    System.out.println("No se encontró el cliente con ID " + cedula);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el cliente: " + e.getMessage());
        }
        return cliente;
    }
    public void registroProducto(Producto producto){
        String consulta = "INSERT INTO producto (id,Nombre,Precio) VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, producto.getId());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setDouble(3, producto.getPrecio());


            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            System.out.println("Producto ingresado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al ingresar el Producto: " + e.getMessage());
        }
    }
    public void registroPedido(Pedido pedido) {
        String consulta = "INSERT INTO pedido (id,producto,cantidad,cedula) VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            // Establecer los valores de los parámetros
            preparedStatement.setInt(1, pedido.getId());
            preparedStatement.setString(2, pedido.getListaProductoString());
            preparedStatement.setInt(3, pedido.getCantidad());
            preparedStatement.setString(4, pedido.getCedula());


            // Ejecutar la consulta
            preparedStatement.executeUpdate();

            System.out.println("Producto ingresado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al ingresar el Producto: " + e.getMessage());
        }
    }
    public int getPedidoId() {
        String consulta = "SELECT MAX(id) AS max_id FROM pedido";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(consulta)) {
            if (resultSet.next()) {
                int maxId = resultSet.getInt("max_id");
                return maxId;
            } else {
                System.out.println("No se encontraron registros en la tabla.");
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el Id: " + e.getMessage());
            return 1;
        }

    }
    public Producto getProducto(String nombre, int cantidad){
        Producto producto = new Producto();

        String consulta = "SELECT id,Precio FROM producto WHERE Nombre = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setString(1, nombre);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    double precio = resultSet.getDouble("Precio");


                    // Crear un objeto Cliente y asignar los valores

                    producto.setId(id);
                    producto.setNombre(nombre);
                    producto.setPrecio(precio);
                    producto.setCantidad(cantidad);


                } else {
                    System.out.println("No se encontró el producto " + nombre);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el producto: " + e.getMessage());
        }
        return producto;
    }

    public void finishConection() throws SQLException {
        connection.close();
    }

    public boolean existecliente(String cedula) throws SQLException {
        String consulta = "SELECT Nombre, Correo FROM cliente WHERE cedula = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setString(1, cedula);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return false;

                } else {
                    return true;
                }
            }
        }
    }
    public boolean existeProducto(String nombre) throws SQLException {
        String consulta = "SELECT id,Precio FROM producto WHERE Nombre = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consulta)) {
            preparedStatement.setString(1, nombre);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;

                } else {
                    return false;
                }
            }
        }
    }


    public void removeProducto(int i) throws SQLException {
        String consulta = "DELETE FROM producto WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(consulta)) {

            statement.setInt(1, i);
            statement.executeUpdate();
            System.out.println("Producto eliminado exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto: " + e.getMessage());
        }

    }
}

