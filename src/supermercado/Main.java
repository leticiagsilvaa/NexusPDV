package supermercado;

import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioLogin;
import supermercado.dados.RepositorioProduto;
import supermercado.negocio.CadastroFuncionario;
import supermercado.negocio.CadastroProduto;
import supermercado.negocio.beans.Caixa;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Produto;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {

        RepositorioFuncionario repositorioFuncionario = CadastroFuncionario.cadastrarFuncionarios();
        RepositorioProduto repositorioProduto = CadastroProduto.cadastrarProdutos();

        RepositorioLogin repositorioLogin = new RepositorioLogin(10);

        //UI.systemLogin();

        //if (repositorioLogin.loginMatch()){ System.out.println("LOGADO"); }
        /*
        //REPOSITORIO
        System.out.println("TESTE DE REPOSITORIO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repositorioFuncionario.getAll()));
        System.out.println("FUNCIONARIO COD 2: ");
        System.out.println(repositorioFuncionario.getOne(2));
        System.out.println("FUNCIONARIOS CHAMADOS NICOLLAS: ");
        System.out.println(Arrays.toString(repositorioFuncionario.findByName("Nicollas Albert")));

        //REPOSITORIO
        System.out.println("TESTE DE REPOSITORIO PRODUTO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repositorioProduto.getAll()));
        System.out.println("PRODUTO COD 2: ");
        System.out.println(repositorioProduto.getOne(2));
        System.out.println("PRODUTOS CHAMADO ARROZ: ");
        System.out.println(Arrays.toString(repositorioProduto.findByName("Arroz")));
        //System.out.println("DIGITE NOME E DESCRIÇÃO E PREÇO PARA ATUALIZAÇÃO: ");
        System.out.println("TODOS: ");
        //repositorioProduto.update(1);
        System.out.println(Arrays.toString(repositorioProduto.getAll()));
*/
        //Teste Estoque
        //Estoque estoque = new Estoque(repositorioProduto);
        //System.out.println("Produtos no estoque após adição:");
        //estoque.listarProdutosNoEstoque();

        //Teste Caixa e Venda
        Caixa caixa1 = new Caixa();
        Funcionario Leticia = repositorioFuncionario.getOne(9);
        caixa1.novaVenda();
        //caixa1.setLogin("sei la"); n funciona
        Produto arroz = repositorioProduto.findByName("Arroz")[0];
        Produto alface = repositorioProduto.getOne(22);
        caixa1.getVenda().adicionarItemLista(arroz, 2);
        caixa1.getVenda().adicionarItemLista(alface, 3);
        //caixa1.getVenda().removerItem(arroz); ainda nao funciona

        caixa1.finalizarVenda();

        Caixa caixa2 = new Caixa();
        caixa2.novaVenda();
        Produto prod1 = repositorioProduto.getOne(11);
        Produto prod2 = repositorioProduto.getOne(22);
        caixa2.getVenda().adicionarItemLista(prod1, 1);
        caixa2.getVenda().adicionarItemLista(prod2, 3);

        caixa2.finalizarVenda();

}}
