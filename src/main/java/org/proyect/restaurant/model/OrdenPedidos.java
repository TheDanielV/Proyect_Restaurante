package org.proyect.restaurant.model;

public class OrdenPedidos {
	private int id;
	private Cliente client;
	private Pedido pedido;

	public OrdenPedidos() {
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


	public void emitirOrden(Pedido pedido) {
		System.out.println("Platos a preparar:");
		for (int i = 0; i < pedido.getListaProducto().size(); i++){
			System.out.println("Tipo: " + pedido.getListaProducto().get(i).getNombre() + ", Cantidad: " + pedido.getListaProducto().get(i).getCantidad() );
		}
		System.out.println("A la mesa: " + pedido.getmesa());
	}
}
