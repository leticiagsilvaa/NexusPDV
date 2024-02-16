package supermercado.dados.load;

import supermercado.dados.RepositorioLogin;
import supermercado.negocio.beans.Login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadLogin {
    public static RepositorioLogin cadastrarLogins(){
        supermercado.dados.RepositorioLogin repositorio = new RepositorioLogin(10);

        String path = "src/supermercado/arquivos/loginTeste.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                String login = line;
                line = br.readLine();
                String pass = line;
                repositorio.add(new Login(login, pass));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return repositorio;
    };
}
