package poo.model;
public class ChequeTerceros extends Cheque{
    private String empresaEmisora;

    public ChequeTerceros(int idDocumento, int cuit, Boolean estaPago, double monto, String empresaEmisora) {
        super(idDocumento, cuit, estaPago, monto);
        this.empresaEmisora = empresaEmisora;
    }

    public String getEmpresaEmisora() {
        return empresaEmisora;
    }

    @Override
    public Boolean getEstaPago() {
        return super.getEstaPago();
    }

    @Override
    public double getMonto() {
        return super.getMonto();
    }

    @Override
    public int getCuit() {
        return super.getCuit();
    }
}
