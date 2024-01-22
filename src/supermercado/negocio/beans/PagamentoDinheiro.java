package supermercado.negocio.beans;

import supermercado.negocio.exceptions.PagamentoException;

import java.time.LocalDateTime;

public class PagamentoDinheiro extends Pagamento {
    private Double troco;

    public PagamentoDinheiro(StatusPedido status, int id, LocalDateTime data, Venda venda, Double valor, Double troco) {
        super(status, id, data, venda, valor);
        this.troco = troco;
    }

    public Double getTroco() {
        return troco;
    }

    public void setTroco(Double troco) throws PagamentoException {
        if (troco != null && troco < 0) {
            throw new PagamentoException("O valor do troco deve ser maior ou igual a zero.");
        }
        this.troco = troco;
    }

    @Override
    public void pagar() {
        setStatus(StatusPedido.COMPRA_CONCLUIDA);
    }
}
