package poo.model;
abstract class Documento {
    int id;
    int cuit;
    Boolean estaPago;
    double monto;

    public Documento(int idDocumento, int cuit, Boolean estaPago, double monto) {
    }


    public int getCuit() {
        return cuit;
    }

    public Boolean getEstaPago() {
        return estaPago;
    }

    public double getMonto() {
        return monto;
    }
}

