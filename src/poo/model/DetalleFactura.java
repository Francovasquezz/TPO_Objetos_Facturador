package poo.model;
public class DetalleFactura {
    private int numeroRenglon;
    private ProductoPorProveedor producto;
    private int cantidad;
    private double precioFinal;

    public DetalleFactura() {
    }
    public DetalleFactura(int numeroRenglon, ProductoPorProveedor producto, int cantidad, double precioFinal) {
        this.numeroRenglon = numeroRenglon;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioFinal = precioFinal;
    }

    public ProductoPorProveedor getProducto() {
        return producto;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void getPrecioPorProveedor(){

    }
}
