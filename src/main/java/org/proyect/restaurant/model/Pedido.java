package org.proyect.restaurant.model;


import java.util.ArrayList;

public class Pedido {
	private int id;
	private String hora;
	private Producto product = new Producto();
	private ArrayList<Producto> listaProducto = new ArrayList<>();
	private int mesa;
	private int cantidad;
	private double subtotal = 0;

	public Pedido() {

	}

	public boolean agregarPedido(String producto, int cantidad) {
		if (product.validarExistencia(producto)) {
			listaProducto.add(product.getProdcuto(producto, cantidad));
			return true;
		}else{
			listaProducto.add(product);
			return false;
		}
    }

	public ArrayList<Producto> getListaProducto() {
		return listaProducto;
	}

	public double getSubtotal() {
		calcularSubTotal();
		return subtotal;
	}

	private void calcularSubTotal(){
		/*for(int i = 0; i < listaProducto.size(); i++ ) {
    		subtotal = subtotal + (listaProducto.get(i).getPrecio()* listaProducto.get(i).getCantidad());
    	}*/
		for(Producto producto : listaProducto){
			subtotal =subtotal+ (producto.getPrecio()*producto.getCantidad());
		}
    }
}
