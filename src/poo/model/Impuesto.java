package poo.model;

import poo.enums.TipoImpuesto;

public class Impuesto {

    private int id;
    private TipoImpuesto tipo;
    private double porcentaje;

    public Impuesto(int id, TipoImpuesto tipo, double porcentaje) {
        this.id = id;
        this.tipo = tipo;
        this.porcentaje = porcentaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoImpuesto getTipo() {
        return tipo;
    }

    public void setTipo(TipoImpuesto tipo) {
        this.tipo = tipo;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
