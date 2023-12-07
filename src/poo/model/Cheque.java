package poo.model;

import java.util.Date;

abstract class Cheque extends Documento{
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String firmante;
    private double importe;


    public Cheque(int idDocumento, int cuit, Boolean estaPago, double monto) {
        super(idDocumento, cuit, estaPago, monto);
    }
}
