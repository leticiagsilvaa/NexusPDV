package supermercado.negocio.beans;

import java.time.LocalDateTime;

public class PagamentoCartao extends Pagamento{
    private String numeroCartao;

    public PagamentoCartao(OrderStatus status, int id, LocalDateTime data, Venda venda, Double valor, String numeroCartao) {
        super(status, id, data, venda, valor);
        this.numeroCartao = numeroCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) throws PagamentoCartaoException {
        if (numeroCartao == null || numeroCartao.isEmpty()) {
            throw new PagamentoCartaoException("O número do cartão não pode estar vazio.");
        }
        this.numeroCartao = numeroCartao;
    }

    @Override
    public void pagar() {
        
        System.out.println("Pagamento com cartão realizado. Número do cartão: " + numeroCartao);
        setStatus(OrderStatus.ENTREGUE);  
    }
}

        
    }

}
