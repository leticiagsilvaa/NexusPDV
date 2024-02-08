package supermercado.negocio;

import supermercado.dados.RepositorioLogin;
import supermercado.dados.RepositorioFuncionario;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Produto;
import supermercado.negocio.beans.Venda;
import supermercado.negocio.exceptions.DuplicadoException;
import supermercado.negocio.exceptions.NaoExisteException;

public class Fachada {

    private CadastroFuncionario funcionarios;
    private CadastroProduto produtos;
    private CadastroVenda vendas;
    private CadastroLogin logins;
    private static Fachada instance;

    public static Fachada getInstance() {
        if (instance == null) {
            instance = new Fachada();
        }
        return instance;
    }

    private Fachada() {
        this.funcionarios = new CadastroFuncionario(RepositorioFuncionario.getInstance());
        //this.produtos = new CadastroProduto(new RepositorioProduto(100));
        //this.vendas = new CadastroVenda(RepositorioVenda(1000));
        this.logins = new CadastroLogin(new RepositorioLogin(10));
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws DuplicadoException {
        this.funcionarios.register(funcionario);
    }

    public void cadastrarLogin(Login login) throws DuplicadoException {
        this.logins.register(login);
    }

    public void cadastrarProdutos(Produto produto) throws DuplicadoException {
        this.produtos.register(produto);
    }

    public void cadastrarVenda(Venda venda) throws DuplicadoException {
        this.vendas.register(venda);
    }

    public Funcionario procurarFuncionario(int codigo) throws NaoExisteException {
        return this.funcionarios.search(codigo);
    }

    public Funcionario procurarLoginFuncionario(String login) throws NaoExisteException {
        return this.funcionarios.findByUser(login);
    }

    public Login procurarLogin(int codigo) throws NaoExisteException {
        return this.logins.search(codigo);
    }

    public Login[] getAll() throws NaoExisteException {
        return this.logins.getAll();
    }

    public Venda procurarVenda(int codigo) throws NaoExisteException {
        return this.vendas.search(codigo);
    }

    public Produto procurarProduto(int codigo) throws NaoExisteException {
        return this.produtos.search(codigo);
    }

    public void removerFuncionario(int codigo) throws NaoExisteException {
        this.funcionarios.delete(codigo);
    }

    public void removerLogin(int codigo) throws NaoExisteException {
        this.logins.delete(codigo);
    }

    public void removerProduto(int codigo) throws NaoExisteException {
        this.produtos.delete(codigo);
    }

    public void removerVenda(int codigo) throws NaoExisteException {
        this.vendas.delete(codigo);
    }

    public String loginMatch(Login login) throws NaoExisteException {
        return this.logins.loginMatch(login);
    }
}