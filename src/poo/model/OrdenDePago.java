package poo.model;
import poo.enums.FormaPago;

import java.time.LocalDate;

public class OrdenDePago {
    private int idOrdenDePago;
    private double totalCancelar;
    private FormaPago formaPago;
    private double totalRetenciones;
    private LocalDate fecha;



    public OrdenDePago(int idOrdenDePago, double totalCancelar, FormaPago formaPago, double totalRetenciones, LocalDate fecha) {
        this.idOrdenDePago = idOrdenDePago;
        this.totalCancelar = totalCancelar;
        this.formaPago = formaPago;
        this.totalRetenciones = totalRetenciones;
        this.fecha = fecha;
    }

    public void getDocumentosAsociados(){};

    public int getIdOrdenDePago() {
        return idOrdenDePago;
    }

    public double getTotalCancelar() {
        return totalCancelar;
    }

    public FormaPago getFormaPago() {return formaPago;}

    public double getTotalRetenciones() {
        return totalRetenciones;
    }
    public LocalDate getFecha() {return fecha;}

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

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
