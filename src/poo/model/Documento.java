package poo.model;
abstract class Documento {
    int id;
    int cuit;
    Boolean estaPago;
    double monto;

    public Documento(int id, int cuit, Boolean estaPago, double monto) {
        this.id = id;
        this.cuit = cuit;
        this.estaPago = estaPago;
        this.monto = monto;
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
}

