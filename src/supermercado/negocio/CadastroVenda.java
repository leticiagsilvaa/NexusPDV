package supermercado.negocio;

import supermercado.dados.RepositorioVenda;
import supermercado.negocio.beans.Venda;
import supermercado.negocio.exceptions.DuplicadoException;
import supermercado.negocio.exceptions.NaoExisteException;

public class CadastroVenda {
    private RepositorioVenda repositorio;

    public CadastroVenda(RepositorioVenda repositorio){
        this.repositorio = repositorio;
    }

    public void register(Venda venda) throws DuplicadoException {
        if (venda == null) {
            throw new IllegalArgumentException("Campos precisam ser preenchidos integralmente");
        } else {
            if (this.repositorio.exists(venda.getIdVenda())) {
                this.repositorio.add(venda);
            } else {
                throw new DuplicadoException("Venda já existe");
            }
        }
    }

    public void unregister(int codigo) throws NaoExisteException {
        Venda login = this.repositorio.getOne(codigo);
        if (login != null) {
            this.repositorio.delete(codigo);
        } else {
            throw new NaoExisteException("Código da venda não existe!");
        }
    }

    public Venda search(int codigo) throws NaoExisteException {
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
