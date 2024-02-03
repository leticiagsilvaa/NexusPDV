package supermercado.negocio;

import supermercado.dados.RepositorioLogin;
import supermercado.negocio.beans.Login;
import supermercado.negocio.exceptions.DuplicadoException;
import supermercado.negocio.exceptions.NaoExisteException;

public class CadastroLogin {

    private static RepositorioLogin repositorio;

    public CadastroLogin(RepositorioLogin repositorio){
        this.repositorio = repositorio;
    }

    public static void register(Login login) throws DuplicadoException {
            if (login == null) {
                throw new IllegalArgumentException("Campos precisam ser preenchidos integralmente");
            } else {
                if (repositorio.exists(login.getCodigo())) {
                    repositorio.add(login);
                } else {
                    throw new DuplicadoException("Login já cadastrado");
                }
            }
    }

    public void unregister(int codigo) throws NaoExisteException {
        Login login = this.repositorio.getOne(codigo);
        if (login != null) {
            this.repositorio.delete(codigo);
        } else {
            throw new NaoExisteException("Código do login não existe!");
        }
    }

    public Login search(int codigo) throws NaoExisteException {
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
