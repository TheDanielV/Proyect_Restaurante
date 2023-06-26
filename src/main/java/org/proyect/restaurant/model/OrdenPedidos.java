package org.proyect.restaurant.model;

public class OrdenPedidos {
	private int id;
	private Cliente client;
	private Pedido pedido;
	public void generarOrden() {
			
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Cliente getClient() {
		return client;
	}

	public int getId() {
		return id;
	}

	public Pedido getPedido() {
		return pedido;
	}
}
