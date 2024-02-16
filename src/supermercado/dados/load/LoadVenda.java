package supermercado.dados.load;

import supermercado.dados.RepositorioLogin;
import supermercado.dados.RepositorioVenda;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Venda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadVenda {
    public static RepositorioVenda cadastrarVenda(){
        RepositorioVenda repositorio = new RepositorioVenda(1000);

        String path = "src/supermercado/arquivos/venda.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String id = line;
                line = br.readLine();
                String nome = line;
                line = br.readLine();
                String cpf = line;
                line = br.readLine();
                String login = line;
                line = br.readLine();
                String pass = line;
                repositorio.add(new Venda(Integer.parseInt(id), new Funcionario(nome,cpf,new Login(login,pass))));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return repositorio;
    };
}
