package supermercado.negocio.beans;

import java.util.ArrayList;
import java.util.List;
import supermercado.negocio.exceptions.PagamentoException;
public class Venda {

    private int idVenda;
    private static int totalIdVenda;
    private List<Item> listaItens;
    private Double subtotal = 0.0;
    private Double troco;
    private Pagamento pagamento;
    private int idCaixa;
    private Funcionario funcionario;

    public Venda(int idCaixa, Funcionario funcionario) {
        this.idVenda = getIdVenda();
        this.idCaixa = idCaixa;
        this.funcionario = funcionario;
        this.listaItens = new ArrayList<>();
    }

    public int getIdVenda() {
        return totalIdVenda++;
    }

    public void setListaItens(List<Produto> produto) {
        this.listaItens = listaItens;
    }

    public List<Item> getListaItens() {
        return listaItens;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double calcularTotal() {
        Double total = 0.0;
        for(Item item: listaItens){
            total += item.getProduto().getValorProd() * item.getQuantidadeItem();
        }
        return total;
    }

    public void adicionarItemLista(Produto produto, int quantidade) {
        listaItens.add(new Item(produto, quantidade));
    }

    public void removerItem(Item item) {
        if (listaItens.contains(item)) {
            listaItens.remove(item);
            subtotal -= item.calcularValorParcial();
        } else {
            System.out.println("O item não está na lista da venda.");
        }
    }

    public Double getTroco() {
        return this.troco;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void efetuarPagamento(Pagamento pagamento) throws PagamentoException {
        if (pagamento == null) {
            throw new PagamentoException("Forma de pagamento inválida.");
        }

        pagamento.pagar();

        if (pagamento instanceof PagamentoDinheiro) {
            Double total = calcularTotal();
            PagamentoDinheiro pagamentoDinheiro = (PagamentoDinheiro) pagamento;
            Double valorPago = total + pagamentoDinheiro.getTroco();
            if (valorPago >= total) {
                this.troco = valorPago - total;
            } else {
                throw new PagamentoException("Valor pago insuficiente.");
            }
        }
    }
}
