package supermercado.negocio.beans;

import supermercado.negocio.exceptions.PagamentoException;

import java.time.LocalDateTime;

public class PagamentoCartao extends Pagamento{
    private String numeroCartao;

    public PagamentoCartao(StatusPedido status, int id, LocalDateTime data, Venda venda, Double valor, String numeroCartao) {
        super(status, id, data, venda, valor);
        this.numeroCartao = numeroCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) throws PagamentoException {
        if (numeroCartao == null || numeroCartao.isEmpty()) {
            throw new PagamentoException("O número do cartão não pode estar vazio.");
        }
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void pagar() {
        
        System.out.println("Pagamento com cartão realizado. Número do cartão: " + numeroCartao);
        setStatus(StatusPedido.COMPRA_CONCLUIDA);
    }
}
