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

        for (Produto produto : this.venda.getListaItens()) {
            Item item = new Item(produto, 1);  // Assumindo que a quantidade desejada é 1
            itens.add(item);
        }

        NotaFiscal nota = new NotaFiscal(this.idCaixa, this.funcionario, itens);
        nota.gerarNota(this.venda);

        // Reiniciar a venda ou definir como null
        this.venda = null;
    }




}

