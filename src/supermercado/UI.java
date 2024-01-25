package supermercado;

import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Produto;

import java.time.LocalDate;
import java.util.Scanner;

public class UI {

    public static Login systemLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor, digite suas credenciais para entrar no sistema");
        System.out.println("Digite seu código de login: ");
        String login = sc.next();
        System.out.println("Digite sua senha: ");
        String senha = sc.next();
        return new Login(login, senha);
    }
    public static void modeloNotaFiscal(LocalDate data, Funcionario funcionario, Produto produto){
        System.out.printf("Data da Venda: " + data + "\n" +
        "Atendente: "+ funcionario.getNomeFuncionario() + "\n" + "\n" +
        "Nome do produto: " + produto.getNomeProd() + "\n" +
        "Preço : " + produto.getValorProd() + "\n" +
                "-----------------------------------------------------\n"+

               "Total da Venda: 			               R$  ");
    }

}
