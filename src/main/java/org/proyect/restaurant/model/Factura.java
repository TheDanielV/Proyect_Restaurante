package org.proyect.restaurant.model;


public class Factura {

    private double total;
    private Cliente customer;
    private Pedido pedido;
    private OrdenPedidos pedidos;
    private int numFactura;
    
    public  Factura(Cliente client, Pedido pedido) {
        this.customer = client;
        this.pedido = pedido;
    }
    public void emitirFactura(){

    	pedido.getSubtotal();
        this.pedidos = new OrdenPedidos();
        pedidos.generarOrden();
    }
    public  double calcularTotal(Pedido pedido) {
    	
    	total= pedido.getSubtotal()+(pedido.getSubtotal()* 0.12);
    	
		return calcularDescuento();
	}
    public double calcularDescuento() {
        double aplicarDescuento=total;

        if(total>20)
            aplicarDescuento= total-(total*0.1);

        return aplicarDescuento;
    }
}






















