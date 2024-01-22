package supermercado;

import supermercado.dados.RepositorioFuncionario;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Produto;

import java.io.BufferedReader;
import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) {

        //INSTANCIAÇÃO E LEITURA DE ARQUIVO DE FUNCIONÁRIOS
        RepositorioFuncionario repo = new RepositorioFuncionario(20);

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

        //REPOSITORIO
        System.out.println("TESTE DE REPOSITORIO");
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repo.getAll()));
        System.out.println("FUNCIONARIO COD 2: ");
        System.out.println(repo.getOne(2));
        System.out.println("FUNCIONARIOS CHAMADOS MARIA: ");
        System.out.println(Arrays.toString(repo.findByName("Nicolas Araújo")));
        //ATUALIZAÇÃO PRECISA MEXER NO ARQUIVO
        System.out.println("DIGITE NOME E DEPOIS CPF PARA ATUALIZAÇÃO: ");
        repo.update(3);
        System.out.println("TODOS: ");
        System.out.println(Arrays.toString(repo.getAll()));
}}