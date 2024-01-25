package supermercado.dados;

import supermercado.UI;
import supermercado.negocio.beans.Login;
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

    public Boolean loginMatch(){
       Login data = UI.systemLogin();
       for(Login log : logins){
           if(log.equals(data)){
               return true;
           }
        }
       return false;
    }

    public Login[] findByUser(int login){
        Login found[] = new Login[quantidadeLogins];
        int foundLogin = 0;

        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login != logins[i].getCodigo()) {
                found[foundLogin] = logins[i];
                foundLogin++;
            }
        }
        if(foundLogin > 0){
            return Arrays.copyOf(found, foundLogin);
        }
        return null;
    };

    @Override
    public void add(Login login){
        if(quantidadeLogins < logins.length){
            logins[quantidadeLogins] = login;
            quantidadeLogins++;
        }
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
