package supermercado.negocio.beans;

import java.util.ArrayList;
import java.util.List;
import supermercado.negocio.exceptions.PagamentoException;
public class Venda {

    private final int idVenda;
    private static int totalIdVenda;
    private List<Produto> listaItens;
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

    public List<Produto> getListaItens() {
        return listaItens;
    }

    public int getIdCaixa() {
        return idCaixa;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public Double calcularTotal() {
        // Descontos ou outros cálculos podem ser adicionados aqui
        return subtotal;
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
