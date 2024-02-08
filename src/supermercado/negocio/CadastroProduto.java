package supermercado.negocio;

import supermercado.dados.RepositorioProduto;
import supermercado.negocio.beans.Produto;
import supermercado.negocio.exceptions.DuplicadoException;
import supermercado.negocio.exceptions.NaoExisteException;

public class CadastroProduto {

    private RepositorioProduto repositorio;

    public CadastroProduto(RepositorioProduto repositorio) {
        this.repositorio = repositorio;
    }

    public void register(Produto produto) throws DuplicadoException {
        if (produto == null) {
            throw new IllegalArgumentException("Campos precisam ser preenchidos integralmente");
        } else {
            if (this.repositorio.exists(produto.getCodigoProd())) {
                this.repositorio.add(produto);
            } else {
                throw new DuplicadoException("Funcionário já cadastrado");
            }
        }
    }

    public void unregister(int codigo) throws NaoExisteException {
        Produto login = this.repositorio.getOne(codigo);
        if (login != null) {
            this.repositorio.delete(codigo);
        } else {
            throw new NaoExisteException("Código do produto não existe!");
        }
    }

    public Produto search(int codigo) throws NaoExisteException {
        return this.repositorio.getOne(codigo);
    }

    public boolean exists(int codigo) {
        return this.repositorio.exists(codigo);
    }

    public void delete(int num) throws NaoExisteException {
        this.repositorio.delete(num);
    }

    public void update(int codigo) throws NaoExisteException {
        this.repositorio.update(codigo);
    }
}