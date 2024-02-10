package supermercado.negocio.beans;

import supermercado.negocio.exceptions.PagamentoException;

import java.time.LocalDateTime;

public abstract class Pagamento {

    private StatusPedido status;
    private int id;
    private LocalDateTime data;
    private Venda venda;
    private Double valor;

    public Pagamento(StatusPedido status, int id, LocalDateTime data, Venda venda, Double valor) {
        this.status = status;
        this.id = id;
        this.data = data;
        this.venda = venda;
        this.valor = valor;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public abstract void pagar() throws PagamentoException;
}
