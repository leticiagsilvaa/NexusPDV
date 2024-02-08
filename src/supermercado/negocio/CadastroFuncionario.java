package supermercado.negocio;

import supermercado.dados.RepositorioFuncionario;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.exceptions.DuplicadoException;
import supermercado.negocio.exceptions.NaoExisteException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CadastroFuncionario {

    private static RepositorioFuncionario repositorio;

    public CadastroFuncionario(RepositorioFuncionario repositorio){
        this.repositorio = repositorio;
    }

    public static void register(Funcionario funcionario) throws DuplicadoException{
            if (funcionario == null) {
                throw new IllegalArgumentException("Campos precisam ser preenchidos integralmente");
            } else {
                if (repositorio.exists(funcionario.getCodigoFuncionario())) {
                    repositorio.add(funcionario);
                } else {
                    throw new DuplicadoException("Funcionário já cadastrado");
                }
            }
    }

    public void unregister(int codigo) throws NaoExisteException {
        Funcionario funcionario = this.repositorio.getOne(codigo);
        if (funcionario != null) {
            this.repositorio.delete(codigo);
        } else {
            throw new NaoExisteException("Código do funcionário não existe!");
        }
    }

    public Funcionario search(int codigo) throws NaoExisteException {
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

    public Funcionario findByUser(String userFuncionario) throws NaoExisteException{
        if( userFuncionario != null){
            this.repositorio.findByUser(userFuncionario);
        }
        throw new NaoExisteException("User não existe!");
    }
}
