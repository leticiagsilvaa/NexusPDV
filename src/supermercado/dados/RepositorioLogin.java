package supermercado.dados;

import supermercado.UI;
import supermercado.negocio.beans.Login;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import supermercado.UI.*;

public class RepositorioLogin implements IRepositorio<Login>{
    private int quantidadeLogins;
    private Login logins[];

    public RepositorioLogin(int numeroMaximo){
        logins = new Login[numeroMaximo];
        quantidadeLogins = 0;
    }

    @Override
    public Login[] getAll(){
        for(Login log: logins){
            if(log != null && quantidadeLogins >0){
                return Arrays.copyOf(logins, quantidadeLogins);
            }
        }
        return null;
    };

    @Override
    public Login getOne(int codigo){
        for(int i = 0; i < logins.length; i++){
            if(logins[i] != null && codigo == logins[i].getCodigo()){
                return logins[i];
            }
        }
        return null;
    };

    public String loginMatch(Login login){
       for(int i = 0; i < quantidadeLogins; i++){
           if(logins[i] != null && login.equals(logins[i])){
               return logins[i].getLogin();
           }
        }
       throw new RuntimeException("Login ou senha incorretos. Tente novamente");
    }

    public Login findByUser(String login){
        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login.equals(logins[i].getLogin())) {
                return logins[i];
            }
        }
        return null;
    };

    public void updateWriter(){
        String path = "src/supermercado/arquivos/login.txt";
        String txt[] = new String[25];

        int numeroLinha = 0;

        for(int j = 0; j < logins.length; j++) {
            if (logins[j] != null) {
                txt[numeroLinha] = logins[j].getLogin();
                txt[numeroLinha + 1] = logins[j].getSenha();
                numeroLinha = numeroLinha + 2;
            }
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(String linha : txt){
                if(linha != null){
                    bw.write(linha);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(Login login){
        if(quantidadeLogins < logins.length){
            logins[quantidadeLogins] = login;
            quantidadeLogins++;
        }
        updateWriter();
    };

    @Override
    public void delete(int codigo) {
        for(int i = 0; i < logins.length; i++){
            if(logins[i] != null && codigo == logins[i].getCodigo()) {
                logins[i] = null;
            }
        }
    }

    @Override
    public void update(int codigo) {
        for(int i = 0; i < logins.length; i++){
            if(logins[i] != null && codigo == logins[i].getCodigo()){
                //ver como será o update login
            }
        }
    }
}
