package supermercado.dados;

import supermercado.dados.load.LoadLogin;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RepositorioLogin {

    private static RepositorioLogin instance;
    private int quantidadeLogins;
    private Login logins[];

    public RepositorioLogin(int numeroMaximo) {
        logins = new Login[numeroMaximo];
        quantidadeLogins = 0;
    }


    public static RepositorioLogin getInstance() {
        if (instance == null) {
            instance = LoadLogin.cadastrarLogins();
        }
        return instance;
    }


    public Login[] getAll() {
        for (Login log : logins) {
            if (log != null) {
                return Arrays.copyOf(logins, quantidadeLogins);
            }
        }
        return null;
    }


    public Login getOne(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                return logins[i];
            }
        }
        return null;
    }


    public String loginMatch(Login login) {
        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login.equals(logins[i])) {
                return logins[i].getLogin();
            }
        }
        throw new RuntimeException("Login ou senha incorretos. Tente novamente");
    }

    public Login findByUser(String login) {
        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login.equals(logins[i].getLogin())) {
                return logins[i];
            }
        }
        return null;
    }

    public void add(Login login) {
        if (quantidadeLogins < logins.length) {
            logins[quantidadeLogins] = login;
            quantidadeLogins++;
        }
        updateWriter();
    }


    public void delete(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                logins[i] = null;
            }
        }
        updateWriter();
    }

    public void updateWriter() {
        String path = "src/supermercado/arquivos/loginTeste.txt";
        String txt[] = new String[150];

        int numeroLinha = 0;

        for (int j = 0; j < logins.length; j++) {
            if (logins[j] != null) {
                txt[numeroLinha] = logins[j].getLogin();
                txt[numeroLinha + 1] = logins[j].getSenha();
                numeroLinha = numeroLinha + 2;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for(int i =0; i < txt.length -1; i++) {
                if (txt[i] != null) {
                    bw.write(txt[i]);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int codigo) {

    }
    public boolean exists(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                return true;
            }
        }
        return false;
    }
}