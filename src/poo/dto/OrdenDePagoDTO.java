package poo.dto;

import poo.enums.FormaPago;
import poo.model.OrdenDePago;

import java.time.LocalDate;
import java.util.Date;

public class OrdenDePagoDTO {
    private int idOrdenDePago;
    private double totalCancelar;
    private FormaPago formaPago;
    private double totalRetenciones;
    private String fecha;

    public OrdenDePagoDTO(int idOrdenDePago, double totalCancelar, FormaPago formaPago, double totalRetenciones, String fecha) {
        this.idOrdenDePago = idOrdenDePago;
        this.totalCancelar = totalCancelar;
        this.formaPago = formaPago;
        this.totalRetenciones = totalRetenciones;
        this.fecha = fecha;
    }

    public int getIdOrdenDePago() {
        return idOrdenDePago;
    }

    public double getTotalCancelar() {
        return totalCancelar;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public double getTotalRetenciones() {
        return totalRetenciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setIdOrdenDePago(int idOrdenDePago) {
        this.idOrdenDePago = idOrdenDePago;
    }

    public void setTotalCancelar(double totalCancelar) {
        this.totalCancelar = totalCancelar;
    }
    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public void setTotalRetenciones(double totalRetenciones) {
        this.totalRetenciones = totalRetenciones;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}