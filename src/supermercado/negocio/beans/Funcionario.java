package supermercado.negocio.beans;

public class Funcionario {
    Login login;
    private int codigoFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String enderecoFuncionario;

    public Funcionario(Login login, int codigo, String nome, String cpf, String endereco){
        this.login = login;
        this.codigoFuncionario = codigo;
        this.nomeFuncionario = nome;
        this.cpfFuncionario = cpf;
        this.enderecoFuncionario = endereco;
    }

    public String getLogin() {
        return login.getLogin();
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }
}

