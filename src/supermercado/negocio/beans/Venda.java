package supermercado.negocio.beans;

import java.util.ArrayList;
import java.util.Collection;

public class Venda {

    private final int idVenda;
    private static int totalIdVenda;
    private final Collection listaProdutos = new ArrayList();
    private Double valorTotalVenda = 0.0;
    private Double troco;
    private Pagamento pagamento;
    private int idCaixa;

    public Venda(int idCaixa){
        Venda.totalIdVenda++;
        this.idVenda =  totalIdVenda;
        this.idCaixa = idCaixa;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public Collection getListaProdutos(){
        return this.listaProdutos;
    }
    public int getIdCaixa(){
        return this.idCaixa;
    }

    public Double getValorTotalVenda(){
        return this.valorTotalVenda;
    }

/*
    public void adicionarProdutoVenda(Item item) {
        getListaProdutos.add(item);
        valorTotalVenda += item.getValorTotalVenda();
    }

    public void removerProdutoVenda(Item item) {
        getListaProdutos.remove(item);
        valorTotal -= item.getValorTotalVenda();
    }

    public Double getValorTotal() {
        return this.valorTotal;
    }

    public Double getTroco() {
        return this.troco;
    }

    public Double getIdVenda() {
        return this.idVenda;
    }

    // falta finalizar e calcular troco
*/
}
