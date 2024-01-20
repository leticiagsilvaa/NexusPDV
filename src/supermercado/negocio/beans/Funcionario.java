package supermercado.negocio.beans;

public class Funcionario {
    Login login;
    private int codigoFuncionario;
    private String nomeFuncionario;
    private String cpfFuncionario;
    private static int contadorCodigo = 0;

    public Funcionario(Login login, String nome, String cpf){
        this.login = login;
        this.codigoFuncionario = gerarNovoCodigo();
        this.nomeFuncionario = nome;
        this.cpfFuncionario = cpf;
    }

    private int gerarNovoCodigo(){
        return ++contadorCodigo;
    }
    public String getLogin() {
        return login.getLogin();
    }

    public int getCodigoFuncionario() {
        return codigoFuncionario;
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

    @Override
    public String toString() {
        return  "Código: " + codigoFuncionario + "\n" +
                "Nome: " + nomeFuncionario + "\n" +
                "CPF: " + cpfFuncionario + "\n";
    }
}

