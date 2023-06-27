package org.proyect.restaurant.model;


import org.proyect.restaurant.conection.DbConection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Pedido {
	private int id;
	private Producto product = new Producto();
	private ArrayList<Producto> listaProducto = new ArrayList<>();
	private int mesa;
	private int cantidad = 0;
	private double subtotal = 0;
	private String cedula;

	public Pedido() {

	}

	public boolean agregarPedido(String producto, int cantidad, DbConection conection, String cedula) throws SQLException {
		this.cedula= cedula;
		if (product.validarExistencia(producto, conection)) {
			listaProducto.add(product.getProdcuto(producto, cantidad, conection));
			return true;
		}else{
			return false;
		}
    }

	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}
	public String getListaProductoString(){
		String listaString = "";
		for(int i = 0; i < (this.listaProducto.size() -1); i++){
			listaString = listaString + listaProducto.get(i).getNombre() + ", ";
		}
		return listaString = listaString + listaProducto.get(this.listaProducto.size() -1).getNombre();
	}

	public double getSubtotal() {
		calcularSubTotal();
		return subtotal;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = this.cantidad + cantidad;
	}

	private void calcularSubTotal(){
		/*for(int i = 0; i < listaProducto.size(); i++ ) {
    		subtotal = subtotal + (listaProducto.get(i).getPrecio()* listaProducto.get(i).getCantidad());
    	}*/
		for(Producto producto : listaProducto){
			subtotal =subtotal+ (producto.getPrecio()*producto.getCantidad());
		}
    }

	public int getId() {
		return this.id;
	}

	public String getCedula() {
		return cedula;
	}

	public int getCantidad(){
		int listaString = 0;
		for(int i = 0; i < (this.listaProducto.size() -1); i++){
			listaString = listaString + listaProducto.get(i).getCantidad();
		}
		return listaString = listaString + listaProducto.get(this.listaProducto.size() -1).getCantidad();
	}

	public void setId(int i) {
		this.id = i;
	}

	public void setmesa(int i) {
		this.mesa = i;
	}

	public int getmesa() {
		return this.mesa;
	}
}
