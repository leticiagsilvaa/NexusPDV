package supermercado.negocio.beans;

import supermercado.negocio.exceptions.SenhaInvalidaException;

import java.util.Objects;

public class Login{
    private int codigo;

    private String login;
    private String senha;
    private static int contadorCodigo = 0;

    public Login(String login, String senha){
        if(senha.length() < 8){
            throw new SenhaInvalidaException("Senha precisa ter mais de 8 dígitos.");
        }
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
}
