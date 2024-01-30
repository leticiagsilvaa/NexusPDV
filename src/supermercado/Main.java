package supermercado;

import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioLogin;
import supermercado.dados.RepositorioProduto;
import supermercado.negocio.CadastroFuncionario;
import supermercado.negocio.CadastroLogin;
import supermercado.negocio.CadastroProduto;
import supermercado.negocio.beans.Caixa;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Produto;

import java.util.Arrays;

public class Main {
    public static void main(String args[]) {

        RepositorioFuncionario repositorioFuncionario = CadastroFuncionario.cadastrarFuncionarios();
        RepositorioProduto repositorioProduto = CadastroProduto.cadastrarProdutos();
        RepositorioLogin repositorioLogin = CadastroLogin.cadastrarLogins();

        Login input_login = UI.systemLogin();
        String user_funcionario = repositorioLogin.loginMatch(input_login);

        Funcionario funcionario = repositorioFuncionario.findByUser(user_funcionario);

        System.out.println(funcionario.getLogin() + funcionario.getNomeFuncionario());

        //Teste Caixa e Venda
        Caixa caixa1 = new Caixa(funcionario.getNomeFuncionario());
        caixa1.novaVenda();
        Produto arroz = repositorioProduto.findByName("Arroz")[0];
        Produto alface = repositorioProduto.getOne(22);
        caixa1.getVenda().adicionarItemLista(arroz, 2);
        caixa1.getVenda().adicionarItemLista(alface, 3);
        //caixa1.getVenda().removerItem(arroz); ainda nao funciona

        caixa1.finalizarVenda();

        Caixa caixa2 = new Caixa(funcionario.getNomeFuncionario());
        caixa2.novaVenda();
        Produto prod1 = repositorioProduto.getOne(11);
        Produto prod2 = repositorioProduto.getOne(22);
        caixa2.getVenda().adicionarItemLista(prod1, 1);
        caixa2.getVenda().adicionarItemLista(prod2, 3);

        caixa2.finalizarVenda();

        /*
        //REPOSITORIO DE FUNCIONARIOS
        System.out.println("TESTE DE REPOSITORIO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repositorioFuncionario.getAll()));
        System.out.println("FUNCIONARIO COD 2: ");
        System.out.println(repositorioFuncionario.getOne(2));

        //REPOSITORIO DE LOGIN
        System.out.println("TESTE DE REPOSITORIO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repositorioLogin.getAll()));
        System.out.println("LOGIN COD 2: ");
        System.out.println(repositorioLogin.findByUser("lucas.souza"));

        //REPOSITORIO PRODUTOS
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

        //*Teste Estoque
        //Estoque estoque = new Estoque(repositorioProduto);
        //System.out.println("Produtos no estoque após adição:");
        //estoque.listarProdutosNoEstoque();
        */


}}
