package supermercado.negocio.beans;

import supermercado.negocio.exceptions.SenhaInvalidaException;

public class Login{
    private String login;
    private String senha;

    public Login(String login, String senha){
        if(senha.length() < 8){
            throw new SenhaInvalidaException("Senha precisa ter mais de 8 dígitos.");
        }
        this.senha = senha;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }
}
