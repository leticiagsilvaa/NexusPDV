package supermercado.dados;

import supermercado.negocio.beans.Login;
import java.util.Arrays;
import java.util.Scanner;

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
            if(logins[i] != null && codigo == logins[i].getCodigoLogin()){
                return logins[i];
            }
        }
        return null;
    };

    public Login[] findByUser(String login){
        Login encontrado[] = new Login[quantidadeLogins];
        int loginEncontrado = 0;

        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login.equalsIgnoreCase(logins[i].getLogin())) {
                encontrado[loginEncontrado] = logins[i];
                loginEncontrado++;
            }
        }
        if(loginEncontrado > 0){
            return Arrays.copyOf(encontrado, loginEncontrado);
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
            if(logins[i] != null && codigo == logins[i].getCodigoLogin()) {
                logins[i] = null;
            }
        }
    }

    @Override
    public void update(int codigo) {
        for(int i = 0; i < logins.length; i++){
            if(logins[i] != null && codigo == logins[i].getCodigoLogin()){
                //ver como será o update login
            }
        }
    }
}
