package poo.model;

import poo.model.Impuesto;
import poo.model.DetalleFactura;
import poo.model.Documento;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Factura extends Documento {
    private Collection<Impuesto> impuestos;
    private LocalDate fecha;
    private Collection<DetalleFactura> detalles;
    private int cuitProveedor;

    public Factura(int id, int cuit, Boolean estaPago, Collection<Impuesto> impuestos, LocalDate fecha, Collection<DetalleFactura> detalles, int cuitProveedor) {
        super(id, cuit, estaPago, calculateMonto(detalles));
        this.impuestos = impuestos;
        this.fecha = fecha;
        this.detalles = detalles;
        this.cuitProveedor = cuitProveedor;
    }

    private static double calculateMonto(Collection<DetalleFactura> detalles) {
        return detalles.stream()
                .mapToDouble(detalle -> detalle.getProducto().getUltimoPrecio())
                .sum();
    }
    public List<String> getDetallesFacturaNames() {
        return detalles.stream()
                .map(detalle -> detalle.getProducto().getProducto().getNombreProducto())
                .collect(Collectors.toList());
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Collection<Impuesto> getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Collection<Impuesto> impuestos) {
        this.impuestos = impuestos;
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

    public void getOrdenDeCompraById(){

    };
}
