package supermercado.negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Caixa {

    private static int totalCaixa;
    private final int idCaixa;

    private Venda venda;
    private String loginFuncionario;
    private Funcionario funcionario;

    public Caixa(){
        Caixa.totalCaixa++;
        idCaixa = totalCaixa;
    }

    public void setLogin(String login){
        this.loginFuncionario = login;
    }

    public void novaVenda(){
        this.venda = new Venda(this.idCaixa, this.loginFuncionario);
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

        NotaFiscal nota = new NotaFiscal(this.idCaixa, this.loginFuncionario, itens);
        nota.gerarNota(this.venda);

        // Reiniciar a venda ou definir como null
        this.venda = null;
    }




}

