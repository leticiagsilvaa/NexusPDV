package supermercado.dados;

import supermercado.negocio.beans.Funcionario;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class RepositorioFuncionario implements IRepositorio<Funcionario>{
    private int quantidadeFuncionarios;
    private Funcionario funcionarios[];

    public RepositorioFuncionario(int numeroMaximo){
        funcionarios = new Funcionario[numeroMaximo];
        quantidadeFuncionarios = 0;
    }

    @Override
    public Funcionario[] getAll(){
        for(Funcionario funcionario: funcionarios){
            if(funcionario != null && quantidadeFuncionarios >0){
                return Arrays.copyOf(funcionarios, quantidadeFuncionarios);
            }
        }
        return null;
    };

    @Override
    public Funcionario getOne(int codigo){
        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()){
                return funcionarios[i];
            }
        }
        return null;
    };

    public Funcionario[] findByName(String name){
        Funcionario encontrado[] = new Funcionario[quantidadeFuncionarios];
        int funcionarioEncontrado = 0;

        for (int i = 0; i < quantidadeFuncionarios; i++) {
            if (funcionarios[i] != null && name.equalsIgnoreCase(funcionarios[i].getNomeFuncionario())) {
                encontrado[funcionarioEncontrado] = funcionarios[i];
                funcionarioEncontrado++;
            }
        }
        if(funcionarioEncontrado > 0){
            return Arrays.copyOf(encontrado, funcionarioEncontrado);
        }
        return null;
    };

    @Override
    public void add(Funcionario funcionario){
        if(quantidadeFuncionarios < funcionarios.length){
            funcionarios[quantidadeFuncionarios] = funcionario;
            quantidadeFuncionarios++;
        }
    };

    @Override
    public void delete(int codigo) {
        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()) {
                funcionarios[i] = null;
            }
        }
    }

    @Override
    public void update(int codigo) {
        for(int i = 0; i < funcionarios.length; i++){
            if(funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()){
                Scanner scanner = new Scanner(System.in);
                String nome = scanner.next();
                funcionarios[i].setNomeFuncionario(nome);
                String cpf = scanner.next();
                funcionarios[i].setCpfFuncionario(cpf);
            }
        }
    }
}
