package poo.model;
public class ProductoPorProveedor {
    private Proveedor proveedor;
    private double ultimoPrecio;
    private Producto producto;

    public ProductoPorProveedor() {
    }

    public ProductoPorProveedor(Proveedor proveedor, double ultimoPrecio, Producto producto) {
        this.proveedor = proveedor;
        this.ultimoPrecio = ultimoPrecio;
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }
    public double getUltimoPrecio() {
        return ultimoPrecio;
    }
    public Producto getProducto() {
        return producto;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    public void setUltimoPrecio(double ultimoPrecio) {
        this.ultimoPrecio = ultimoPrecio;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
