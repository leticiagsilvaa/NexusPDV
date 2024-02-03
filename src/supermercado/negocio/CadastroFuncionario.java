package supermercado.negocio;

import supermercado.dados.RepositorioFuncionario;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CadastroFuncionario {
//    public static RepositorioFuncionario cadastrarFuncionarios(){
//        RepositorioFuncionario repositorio = new RepositorioFuncionario(10);
//
//        String path = "src/supermercado/arquivos/funcionarios.txt";
//
//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//            String line = br.readLine();
//
//            while (line != null) {
//                String name = line;
//                line = br.readLine();
//                String cpf = line;
//                line = br.readLine();
//                String login = line;
//                line = br.readLine();
//                String pass = line;
//                repositorio.add(new Funcionario(name, cpf, new Login(login, pass)));
//                line = br.readLine();
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        return repositorio;
//    };
}
