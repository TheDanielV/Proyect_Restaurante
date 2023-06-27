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
        System.out.println("Los datos de su factura son:");
        System.out.println("Nombres: "+ customer.getNombre()+" "+customer.getApellido());
        System.out.println("cedula de identidad: "+customer.getCedula());
        System.out.println("Productos pedidos: ");
        for (int i = 0; i < pedido.getListaProducto().size(); i++ ){
            System.out.println(pedido.getListaProducto().get(i).getNombre()+", " + "x"+pedido.getListaProducto().get(i).getCantidad());
        }
        System.out.println("Total: "+pedido.getSubtotal());
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






















