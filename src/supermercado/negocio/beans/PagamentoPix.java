package supermercado.negocio.beans;

public class PagamentoPix extends MinhaClasse {
    private String codigoPix;

    public PagamentoPix(OrderStatus status, int id, LocalDateTime data, Venda venda, Double valor, String codigoPix) {
        super(status, id, data, venda, valor);
        this.codigoPix = codigoPix;
    }

    public String getCodigoPix() {
        return codigoPix;
    }

    public void setCodigoPix(String codigoPix) throws PagamentoPixException {
        if (codigoPix == null || codigoPix.isEmpty()) {
            throw new PagamentoPixException("O código Pix não pode ser nulo.");
        }
        this.codigoPix = codigoPix;
    }

    @Override
    public void pagar() throws Pagamento {
        
        setStatus(OrderStatus.EFETUADO);

}
