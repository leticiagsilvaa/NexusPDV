package supermercado;

import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioLogin;
import supermercado.dados.RepositorioProduto;
import supermercado.dados.RepositorioVenda;
import supermercado.dados.load.LoadProduto;
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

        RepositorioProduto.getInstance();
        RepositorioVenda.getInstance();
        RepositorioProduto.getInstance();
        RepositorioLogin.getInstance();

        Funcionario funcionario = RepositorioFuncionario.getInstance().findByUser("carlos.oliveira");

        Caixa caixa1 = new Caixa(funcionario);
        caixa1.novaVenda();
        Produto arroz = RepositorioProduto.getInstance().findByName("Arroz")[0];
        Produto alface = RepositorioProduto.getInstance().getOne(22);
        caixa1.getVenda().adicionarItemLista(arroz, 2);
        caixa1.getVenda().adicionarItemLista(alface, 3);

        caixa1.finalizarVenda();

        Caixa caixa2 = new Caixa(funcionario);
        caixa2.novaVenda();
        Produto prod1 = RepositorioProduto.getInstance().getOne(11);
        Produto prod2 = RepositorioProduto.getInstance().getOne(22);
        caixa2.getVenda().adicionarItemLista(prod1, 1);
        caixa2.getVenda().adicionarItemLista(prod2, 3);

        caixa2.finalizarVenda();


//        //REPOSITORIO DE FUNCIONARIOS
//        System.out.println("TESTE DE REPOSITORIO");
//        System.out.println("TODOS: ");
//        System.out.println(Arrays.toString(RepositorioFuncionario.getInstance().getAll()));
//        System.out.println("FUNCIONARIO COD 2: ");
//        System.out.println(RepositorioFuncionario.getInstance().getOne(2));
//        RepositorioFuncionario.getInstance().add(new Funcionario("Malu Vasconcelos", "12345678900", new Login("malu", "12345")));
//        System.out.println(Arrays.toString(RepositorioFuncionario.getInstance().getAll()));
//        RepositorioFuncionario.getInstance().delete(3);
//        System.out.println(Arrays.toString(RepositorioFuncionario.getInstance().getAll()));
//
//        //REPOSITORIO DE LOGINS
//        System.out.println("TESTE DE REPOSITORIO");
//        System.out.println("TODOS: ");
//        System.out.println(Arrays.toString(RepositorioLogin.getInstance().getAll()));
//        System.out.println("LOGIN COD 2: ");
//        System.out.println(RepositorioLogin.getInstance().getOne(2));
//        System.out.println(RepositorioLogin.getInstance().findByUser("carlos.oliveira"));
//        System.out.println(Arrays.toString(RepositorioLogin.getInstance().getAll()));
//
//        //REPOSITORIO PRODUTOS
//        System.out.println("TESTE DE REPOSITORIO PRODUTO");
//        System.out.println("TODOS: ");
//        System.out.println(Arrays.toString(RepositorioProduto.getInstance().getAll()));
//        System.out.println("PRODUTO COD 2: ");
//        System.out.println(RepositorioProduto.getInstance().getOne(2));
//        System.out.println("PRODUTOS CHAMADO ARROZ: ");
//        System.out.println(Arrays.toString(RepositorioProduto.getInstance().findByName("Arroz")));
//        System.out.println("UPDATE: nome, cpf, login");
//        RepositorioProduto.getInstance().update(1);
//        RepositorioProduto.getInstance().delete(40);
//        System.out.println("TODOS: ");
//        System.out.println(Arrays.toString(RepositorioProduto.getInstance().getAll()));


//        try {
//            // Instanciando PagamentoCartao
//            PagamentoCartao pagamentoCartao = new PagamentoCartao(
//                    StatusPedido.PENDENTE,
//                    1,
//                    LocalDateTime.now(),
//                    new Venda(0,funcionario),
//                    100.0,
//                    "1234567890123456"
//            );
//
//            // definindo um número de cartão nulo
//            pagamentoCartao.setNumeroCartao(null);
//        } catch (PagamentoException e) {
//
//            System.out.println("o numero do cartão nao pode ser nulo");
//        }
//        try {
//            // Instanciando um objeto PagamentoPix
//            PagamentoPix pagamentoPix = new PagamentoPix(
//                    StatusPedido.PENDENTE,
//                    3,
//                    LocalDateTime.now(),
//                    new Venda(0,funcionario),
//                    200.0,
//                    "1234567890"
//            );
//
//            // definindo um código Pix nulo
//            pagamentoPix.setCodigoPix(null);
//        } catch (PagamentoException e) {
//            System.out.println(" O codigo Pix não pode ser nulo" );
//        }

    }
}