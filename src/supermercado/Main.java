package supermercado;

import supermercado.dados.RepositorioFuncionario;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Produto;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        //INSTANCIAÇÕES
        Login login = new Login("Luffy", "12345678");
        Funcionario funcionario = new Funcionario(login, "José" ,"1234555");
        Funcionario funcionario1 = new Funcionario(login, "Catarina" ,"1245");
        Funcionario funcionario2 = new Funcionario(login, "Maria" ,"1233445");
        Funcionario funcionario3 = new Funcionario(login, "Maria", "1234");
        Produto produto = new Produto("Café", "Bebida", 2.50F);
        Produto produto2 = new Produto("Arroz", "Comida", 3.50F);

        //REPOSITORIO
        System.out.println("TESTE DE REPOSITORIO");
        RepositorioFuncionario repo = new RepositorioFuncionario(10);
        repo.add(funcionario);
        repo.add(funcionario1);
        repo.add(funcionario2);
        repo.add(funcionario3);
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repo.getAll()));
        repo.delete(1);
        System.out.println("TODOS MENOS DELETADO: ");
        System.out.println(Arrays.toString(repo.getAll()));
        System.out.println("FUNCIONARIO COD 2: ");
        System.out.println(repo.getOne(2));
        System.out.println("FUNCIONARIOS CHAMADOS MARIA: ");
        System.out.println(Arrays.toString(repo.findByName("Maria")));
        System.out.println("DIGITE NOME E DEPOIS CPF PARA ATUALIZAÇÃO: ");
        repo.update(3);
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repo.getAll()));
}}