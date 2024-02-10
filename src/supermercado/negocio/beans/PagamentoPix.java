package supermercado.negocio.beans;

import supermercado.negocio.exceptions.PagamentoException;

import java.time.LocalDateTime;

public class PagamentoPix extends Pagamento {
    private String codigoPix;

    public PagamentoPix(StatusPedido status, int id, LocalDateTime data, Venda venda, Double valor, String codigoPix) {
        super(status, id, data, venda, valor);
        this.codigoPix = codigoPix;
    }

    public String getCodigoPix() {
        return codigoPix;
    }

    public void setCodigoPix(String codigoPix) throws PagamentoException {
        if (codigoPix == null || codigoPix.isEmpty()) {
            throw new PagamentoException("O código Pix não pode ser nulo.");
        }
        this.codigoPix = codigoPix;
    }

    @Override
    public void pagar() throws PagamentoException {
        if (getValor() <= 0) {
            throw new PagamentoException("O valor da venda deve ser maior que zero.");
        }

        if (getValor() <= getVenda().calcularTotal()) {
            System.out.println("Pagamento via Pix realizado. Código Pix: " + codigoPix);
            setStatus(StatusPedido.EFETUADO);
        } else {
            throw new PagamentoException("Valor recebido insuficiente para realizar a compra.");
        }
    }
}
