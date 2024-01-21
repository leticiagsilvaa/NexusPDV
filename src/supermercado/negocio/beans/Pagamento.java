package supermercado.negocio.beans;

import java.time.LocalDateTime;

abstract class MinhaClasse {
    public enum OrderStatus {
        PENDENTE, PROCESSANDO, EFETUADO, CANCELADO
    }

    private OrderStatus status;
    private int id;
    private LocalDateTime data;
    private Venda venda;
    private Double valor;

    public MinhaClasse(OrderStatus status, int id, LocalDateTime data, Venda venda, Double valor) {
        this.status = status;
        this.id = id;
        this.data = data;
        this.venda = venda;
        this.valor = valor;
    }

    public MinhaClasse() {
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
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

  
    public abstract void pagar();
}


}

