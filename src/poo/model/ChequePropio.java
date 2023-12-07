package poo.model;
public class ChequePropio extends Cheque{
    public ChequePropio(int idDocumento, int cuit, Boolean estaPago, double monto) {
        super(idDocumento, cuit, estaPago, monto);
    }

    @Override
    public int getCuit() {
        return super.getCuit();
    }

    @Override
    public Boolean getEstaPago() {
        return super.getEstaPago();
    }

    @Override
    public double getMonto() {
        return super.getMonto();
    }

}
