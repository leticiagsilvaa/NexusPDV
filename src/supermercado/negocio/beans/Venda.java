package supermercado.negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private final int idVenda;
    private static int totalIdVenda;
    private final List<Produto> listaItens;
    private Double subtotal = 0.0;
    private Double troco;
    private Pagamento pagamento;
    private int idCaixa;
    private Funcionario funcionario;

    public Venda(int idCaixa, String loginFuncionario){
        Venda.totalIdVenda++;
        this.idVenda =  totalIdVenda;
        this.idCaixa = idCaixa;
        this.listaItens = new ArrayList<>();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public List<Produto> getListaItens(){
        return this.listaItens;
    }
    public int getIdCaixa(){
        return this.idCaixa;
    }

    public Double getSubtotal(){
        return this.subtotal;
    }


    public void adicionarItemLista(Produto produto, int quantidade) {
        Item item = new Item(produto, quantidade);
        listaItens.add(item.getProduto());
        subtotal += item.calcularValorParcial();
    }

    public void removerItem(Item item) {
        if (listaItens.contains(item)) {
            listaItens.remove(item);
            subtotal -= item.calcularValorParcial();
        } else {
            System.out.println("O item não está na lista da venda.");
        }
    }


    public Double calcularTotal() {
        // descontos???
        return subtotal;
    }

    public Double getTroco() {
        return this.troco;
    }


    // falta finalizar e calcular troco

}
