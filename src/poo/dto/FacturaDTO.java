package poo.dto;

import poo.model.Impuesto;
import poo.model.DetalleFactura;

import java.time.LocalDate;
import java.util.Collection;

public class FacturaDTO {
    int id;
    int cuit;
    Boolean estaPago;
    double monto;
    private Collection<Impuesto> impuestos;
    private LocalDate fecha;
    private Collection<DetalleFactura> detalles;
    private int cuitProveedor;

    public FacturaDTO(int id, int cuit, Boolean estaPago, double monto, Collection<Impuesto> impuestos, LocalDate fecha, Collection<DetalleFactura> detalles, int cuitProveedor) {
        this.id = id;
        this.cuit = cuit;
        this.estaPago = estaPago;
        this.monto = monto;
        this.impuestos = impuestos;
        this.fecha = fecha;
        this.detalles = detalles;
        this.cuitProveedor = cuitProveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }

    public Boolean getEstaPago() {
        return estaPago;
    }

    public void setEstaPago(Boolean estaPago) {
        this.estaPago = estaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Collection<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Collection<Impuesto> impuestos) {
        this.impuestos = impuestos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Collection<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(Collection<DetalleFactura> detalles) {
        this.detalles = detalles;
    }

    public int getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(int cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }
}
