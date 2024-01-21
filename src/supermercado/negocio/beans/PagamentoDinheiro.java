package supermercado.negocio.beans;

public class PagamentoDinheiro extends MinhaClasse {
    private Double troco;

    public PagamentoDinheiro(OrderStatus status, int id, LocalDateTime data, Venda venda, Double valor, Double troco) {
        super(status, id, data, venda, valor);
        this.troco = troco;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) throws PagamentoDinheiroException {
        if (troco != null && troco < 0) {
            throw new PagamentoDinheiroException("O valor do troco deve ser maior ou igual a zero.");
        }
        this.troco = troco;
    }

    @Override
    public void pagar() throws MinhaClasseException {
       
        
        setStatus(OrderStatus.EFETUADO);
}
