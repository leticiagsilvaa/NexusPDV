package supermercado.negocio;

import supermercado.dados.RepositorioFuncionario;
import supermercado.negocio.beans.Funcionario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CadastroFuncionario {
    public static RepositorioFuncionario cadastrarFuncionarios(){
        RepositorioFuncionario repositorio = new RepositorioFuncionario(10);

        String path = "src/supermercado/arquivos/funcionarios.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String first_parameter = line;
                line = br.readLine();
                String second_parameter = line;
                repositorio.add(new Funcionario(first_parameter, second_parameter));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return repositorio;
    };
}
