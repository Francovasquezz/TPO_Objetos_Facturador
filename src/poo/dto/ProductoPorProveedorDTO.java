package poo.dto;

public class ProductoPorProveedorDTO {
    private double ultimoPrecio;
    private Long idProducto;
    private Long idProveedor;

    public ProductoPorProveedorDTO() {
    }

    public ProductoPorProveedorDTO(double ultimoPrecio, Long idProducto, Long idProveedor) {
        this.ultimoPrecio = ultimoPrecio;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
    }

    public double getUltimoPrecio() {
        return ultimoPrecio;
    }

    public void setUltimoPrecio(double ultimoPrecio) {
        this.ultimoPrecio = ultimoPrecio;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }
}
