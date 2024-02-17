package supermercado.negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Caixa {

    private static int totalCaixa;
    private final int idCaixa;
    private Venda venda;
    private Funcionario funcionario;

    public Caixa(Funcionario funcionario){
        Caixa.totalCaixa++;
        idCaixa = totalCaixa;
        this.funcionario = funcionario;
    }

    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }

    public void novaVenda(){
        this.venda = new Venda(this.idCaixa, this.funcionario);
    }

    public Venda getVenda(){
        return this.venda;
    }

    public int getIdCaixa(){
        return this.idCaixa;
    }

    public void finalizarVenda() {
        List<Item> itens = new ArrayList<>();

        for (Item produto : this.venda.getListaItens()) {
            Item item = new Item(produto.getProduto(), produto.getQuantidadeItem());
            itens.add(item);
        }

        NotaFiscal nota = new NotaFiscal(this.idCaixa, this.funcionario, itens);
        nota.gerarNota(this.venda);

        this.venda = null;
    }

}

