package supermercado.dados;

import supermercado.negocio.beans.Funcionario;

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
        return funcionarios;
    };

    @Override
    public Funcionario getOne(int codigo){
        for(int i = 0; i < funcionarios.length; i++){
            if(codigo == funcionarios[i].getCodigoFuncionario()){
                return funcionarios[i];
            }
        }
        return null;
    };

    public Funcionario findByName(String name){
        for(int i = 0; i < funcionarios.length; i++){
            if(name.equalsIgnoreCase(funcionarios[i].getNomeFuncionario())){
                return funcionarios[i];
            }
        }
        return null;
    };

    @Override
    public void add(Funcionario funcionario){
        if(quantidadeFuncionarios < funcionarios.length){
            for(int i = 0; i < quantidadeFuncionarios; i++){
                if(funcionarios[i] == null){
                    funcionarios[i] = funcionario;
                }
            }
            funcionarios[quantidadeFuncionarios] = funcionario;
            quantidadeFuncionarios++;
        }
    };

    @Override
    public void delete(int codigo) {
        for(int i = 0; i < funcionarios.length; i++){
            if(codigo == funcionarios[i].getCodigoFuncionario()) {
                funcionarios[i] = null;
            }
        }
    }

    @Override
    public void update(int codigo) {
        for(int i = 0; i < funcionarios.length; i++){
            if(codigo == funcionarios[i].getCodigoFuncionario()){
                Scanner scanner = new Scanner(System.in);
                String cpf = scanner.next();
                funcionarios[i].setCpfFuncionario(cpf);
                String nome = scanner.nextLine();
                funcionarios[i].setNomeFuncionario(nome);
                String endereco = scanner.nextLine();
                funcionarios[i].setEnderecoFuncionario(endereco);
            }
        }

    }
}
