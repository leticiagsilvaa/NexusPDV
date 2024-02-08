package supermercado.negocio.beans;

import supermercado.negocio.exceptions.SenhaInvalidaException;

import java.io.Serializable;
import java.util.Objects;

public class Login implements Serializable {
    private int codigo;
    private String login;
    private String senha;
    private static int contadorCodigo = 0;

    public Login(String login, String senha){
        this.login = login;
        this.senha = senha;
        this.codigo = gerarNovoCodigo();
    }

    private int gerarNovoCodigo(){
        return ++contadorCodigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha(){return senha;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login1 = (Login) o;
        return Objects.equals(login, login1.login) && Objects.equals(senha, login1.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, senha);
    }

    @Override
    public String toString() {
        return "Login: " + login + '\n' +
                "Senha: " + senha + '\n';
    }
}
