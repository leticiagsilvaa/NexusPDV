package supermercado;

import org.w3c.dom.ls.LSOutput;
import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioProduto;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Produto;
import supermercado.negocio.beans.Estoque;

import java.io.BufferedReader;
import java.io.File;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {

        //INSTANCIAÇÃO E LEITURA DE ARQUIVO DE FUNCIONÁRIOS
        RepositorioFuncionario repo = new RepositorioFuncionario(10);

        String path = "src/supermercado/arquivos/funcionarios.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String first_parameter = line;
                line = br.readLine();
                String second_parameter = line;
                repo.add(new Funcionario(first_parameter, second_parameter));
                line = br.readLine();
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        //INSTANCIAÇÃO E LEITURA DE ARQUIVO DE PRODUTOS
        RepositorioProduto repoProd = new RepositorioProduto(50);

        String path_produtos = "src/supermercado/arquivos/produtos.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path_produtos))) {
            String line = br.readLine();

            while (line != null) {
                String first_parameter = line;
                line = br.readLine();
                String second_parameter = line;
                line = br.readLine();
                String third_parameter = line;
                repoProd.add(new Produto(first_parameter, second_parameter, Double.parseDouble(third_parameter)));
                line = br.readLine();
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        //REPOSITORIO
        System.out.println("TESTE DE REPOSITORIO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repo.getAll()));
        System.out.println("FUNCIONARIO COD 2: ");
        System.out.println(repo.getOne(2));
        System.out.println("FUNCIONARIOS CHAMADOS MARIA: ");
        System.out.println(Arrays.toString(repo.findByName("Nicollas Albert")));
        System.out.println("DIGITE NOME E DEPOIS CPF PARA ATUALIZAÇÃO: ");

        //REPOSITORIO
        System.out.println("TESTE DE REPOSITORIO PRODUTO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repoProd.getAll()));
        System.out.println("PRODUTO COD 2: ");
        System.out.println(repoProd.getOne(2));
        System.out.println("PRODUTOS CHAMADO ARROZ: ");
        System.out.println(Arrays.toString(repoProd.findByName("Arroz")));
        System.out.println("DIGITE NOME E DESCRIÇÃO E PREÇO PARA ATUALIZAÇÃO: ");
        System.out.println("TODOS: ");
        repoProd.update(1);
        System.out.println(Arrays.toString(repoProd.getAll()));

        //Teste Estoque
        Estoque estoque = new Estoque(repositorioProduto);
        System.out.println("Produtos no estoque após adição:");
        estoque.listarProdutosNoEstoque();

}}