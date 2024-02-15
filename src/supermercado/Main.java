package supermercado;

import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioLogin;
import supermercado.dados.RepositorioProduto;
import supermercado.negocio.CadastroFuncionario;
import supermercado.negocio.CadastroLogin;
import supermercado.negocio.CadastroProduto;
import supermercado.negocio.Fachada;
import supermercado.negocio.beans.*;
import supermercado.negocio.exceptions.PagamentoException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String args[]) {

        //RepositorioFuncionario repositorioFuncionario = CadastroFuncionario.cadastrarFuncionarios();
        //RepositorioProduto repositorioProduto = CadastroProduto.cadastrarProdutos();

        System.out.println(Arrays.toString(Fachada.getInstance().getAll()));


        //Login input_login = UI.systemLogin();
        //String user_funcionario = repositorioLogin.loginMatch(input_login);

        //Funcionario funcionario = repositorioFuncionario.findByUser(user_funcionario);

       // System.out.println(funcionario.getLogin() + funcionario.getNomeFuncionario());

        //Teste Caixa e Venda
        //Caixa caixa1 = new Caixa(funcionario.getNomeFuncionario());
       // caixa1.novaVenda();
       // Produto arroz = repositorioProduto.findByName("Arroz")[0];
        //Produto alface = repositorioProduto.getOne(22);
        //caixa1.getVenda().adicionarItemLista(arroz, 2);
       // caixa1.getVenda().adicionarItemLista(alface, 3);
        //caixa1.getVenda().removerItem(arroz); ainda nao funciona

       // caixa1.finalizarVenda();

       // Caixa caixa2 = new Caixa(funcionario.getNomeFuncionario());
       // caixa2.novaVenda();
       // Produto prod1 = repositorioProduto.getOne(11);
       // Produto prod2 = repositorioProduto.getOne(22);
       // caixa2.getVenda().adicionarItemLista(prod1, 1);
       // caixa2.getVenda().adicionarItemLista(prod2, 3);

       // caixa2.finalizarVenda();

        /*
        //REPOSITORIO DE FUNCIONARIOS
        System.out.println("TESTE DE REPOSITORIO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repositorioFuncionario.getAll()));
        System.out.println("FUNCIONARIO COD 2: ");
        System.out.println(repositorioFuncionario.getOne(2));



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

        try {
            // Instanciando PagamentoCartao
            PagamentoCartao pagamentoCartao = new PagamentoCartao(
                    StatusPedido.PENDENTE,
                    1,
                    LocalDateTime.now(),
                    new Venda(0,""),
                    100.0,
                    "1234567890123456"
            );

            // definindo um número de cartão nulo
            pagamentoCartao.setNumeroCartao(null);
        } catch (PagamentoException e) {

            System.out.println("o numero do cartão nao pode ser nulo");
        }
        try {
            // Instanciando um objeto PagamentoPix
            PagamentoPix pagamentoPix = new PagamentoPix(
                    StatusPedido.PENDENTE,
                    3,
                    LocalDateTime.now(),
                    new Venda(0,""),
                    200.0,
                    "1234567890"
            );

            // definindo um código Pix nulo
            pagamentoPix.setCodigoPix(null);
        } catch (PagamentoException e) {
            System.out.println(" O codigo Pix não pode ser nulo" );
        }
         */
        // Teste do Estoque
        RepositorioProduto repositorioProduto = RepositorioProduto.getInstance();
        Estoque estoque = new Estoque(repositorioProduto);

        // Adicionando alguns produtos ao estoque
        Produto prod1 = new Produto("Arroz", "Cereais", 5.99, 10);
        Produto prod2 = new Produto("Feijão", "Cereais", 4.5, 15);

        estoque.adicionarProdutoAoEstoque(prod1, 10);
        estoque.adicionarProdutoAoEstoque(prod2, 15);

        // Listando produtos no estoque
        System.out.println("Produtos no estoque após adição:");
        estoque.listarProdutosNoEstoque();

        // Removendo alguns produtos do estoque
        estoque.removerProdutoDoEstoque(prod1.getCodigoProd(), 5);
        estoque.removerProdutoDoEstoque(prod2.getCodigoProd(), 10);

        // Listando produtos no estoque após remoção
        System.out.println("Produtos no estoque após remoção:");
        estoque.listarProdutosNoEstoque();
    }
}
