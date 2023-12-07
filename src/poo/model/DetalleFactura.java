package poo.model;

public class DetalleFactura {
    private int numeroRenglon;
    private ProductoPorProveedor producto;
    private int cantidad;
    private double precioFinal;

    // Constructor sin parámetros
    public DetalleFactura() {
    }

    // Constructor con parámetros
    public DetalleFactura(int numeroRenglon, ProductoPorProveedor producto, int cantidad) {
        this.numeroRenglon = numeroRenglon;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioFinal = calcularPrecioFinal(cantidad);
    }

    // Métodos getter y setter para numeroRenglon
    public int getNumeroRenglon() {
        return numeroRenglon;
    }

    public void setNumeroRenglon(int numeroRenglon) {
        this.numeroRenglon = numeroRenglon;
    }

    // Métodos getter y setter para producto
    public ProductoPorProveedor getProducto() {
        return producto;
    }

    public void setProducto(ProductoPorProveedor producto) {
        this.producto = producto;
    }

    // Métodos getter y setter para cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        // Recalcula el precio final cuando se actualiza la cantidad
        this.precioFinal = calcularPrecioFinal(cantidad);
    }

    // Método getter para precioFinal
    public double getPrecioFinal() {
        return precioFinal;
    }

    // Método para obtener el precio por proveedor
    public double getPrecioPorProveedor() {
        return producto.getUltimoPrecio(); // Suponiendo que hay un método getUltimoPrecio en ProductoPorProveedor
    }

    // Método para calcular el precio final
    private double calcularPrecioFinal(int cantidad) {
        // Calcular el precio final multiplicando la cantidad por el precio
        return cantidad * getPrecioPorProveedor();
    }
}
