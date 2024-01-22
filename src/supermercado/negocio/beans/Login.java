package supermercado.negocio.beans;

import supermercado.negocio.exceptions.SenhaInvalidaException;

public class Login{
    private int codigo;
    private String login;
    private String senha;
    private static int contadorCodigo = 0;

    public int getCodigoLogin() {
        return codigo;
    }

    public Login(String login, String senha){
        if(senha.length() < 8){
            throw new SenhaInvalidaException("Senha precisa ter mais de 8 dígitos.");
        }
        this.senha = senha;
        this.login = login;
        this.codigo = gerarNovoCodigo();
    }

    private int gerarNovoCodigo(){
        return ++contadorCodigo;
    }

    public String getLogin() {
        return login;
    }
}
