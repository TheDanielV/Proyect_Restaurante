package org.proyect.restaurant.model;

import org.proyect.restaurant.conection.DbConection;

import java.sql.SQLException;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int cantidad = 0;

    public Producto(int id, String nombre, double precio,int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = this.cantidad + cantidad;

    }

    public Producto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProdcuto(String producto, int cantidad, DbConection conection) {
        return conection.getProducto(producto, cantidad);
    }

    public boolean validarExistencia(String producto, DbConection conection) throws SQLException {
        return conection.existeProducto(producto);
    }
}