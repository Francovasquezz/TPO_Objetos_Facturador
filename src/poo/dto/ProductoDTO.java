package poo.dto;

import poo.enums.TipoRubro;
import poo.enums.TipoUnidad;

public class ProductoDTO {
    private int idProducto;
    private String nombreProducto;
    private TipoRubro rubro;
    private TipoUnidad tipoUnidad;
    private double tipoIva;

    public ProductoDTO(int idProducto, String nombreProducto, TipoRubro rubro, TipoUnidad tipoUnidad, double tipoIva) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.rubro = rubro;
        this.tipoUnidad = tipoUnidad;
        this.tipoIva = tipoIva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public TipoRubro getRubro() {
        return rubro;
    }

    public void setRubro(TipoRubro rubro) {
        this.rubro = rubro;
    }

    public TipoUnidad getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(TipoUnidad tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public double getTipoIva() {
        return tipoIva;
    }

    public void setTipoIva(double tipoIva) {
        this.tipoIva = tipoIva;
    }
}
