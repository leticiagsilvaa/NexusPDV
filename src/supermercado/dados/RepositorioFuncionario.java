package supermercado.dados;

import supermercado.dados.load.LoadFuncionario;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Produto;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RepositorioFuncionario {
    private static RepositorioFuncionario instance;
    private int quantidadeFuncionarios;
    private Funcionario funcionarios[];

    public RepositorioFuncionario(int numeroMaximo) {
        funcionarios = new Funcionario[numeroMaximo];
        quantidadeFuncionarios = 0;
    }

    public static RepositorioFuncionario getInstance() {
        if (instance == null) {
            instance = LoadFuncionario.cadastrarFuncionarios();
        }
        return instance;
    }

    public Funcionario[] getAll() {
        for (Funcionario f : funcionarios) {
            if (f != null) {
                return Arrays.copyOf(funcionarios, quantidadeFuncionarios);
            }
        }
        return null;
    }


    public Funcionario getOne(int codigo) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()) {
                return funcionarios[i];
            }
        }
        return null;
    }


    public Funcionario[] findByName(String name) {
        Funcionario encontrado[] = new Funcionario[quantidadeFuncionarios];
        int funcionarioEncontrado = 0;

        for (int i = 0; i < quantidadeFuncionarios; i++) {
            if (funcionarios[i] != null && name.equalsIgnoreCase(funcionarios[i].getLogin())) {
                encontrado[funcionarioEncontrado] = funcionarios[i];
                funcionarioEncontrado++;
            }
        }
        if (funcionarioEncontrado > 0) {
            return Arrays.copyOf(encontrado, funcionarioEncontrado);
        }
        return null;
    }


    public Funcionario findByUser(String login) {
        for (int i = 0; i < quantidadeFuncionarios; i++) {
            if (funcionarios[i] != null && funcionarios[i].getLogin().equals(login)) {
                return funcionarios[i];
            }
        }
        return null;
    }


    public void add(Funcionario funcionario) {
        if (quantidadeFuncionarios < funcionarios.length) {
            funcionarios[quantidadeFuncionarios] = funcionario;
            quantidadeFuncionarios++;
        }
        updateWriter();
    }


    public void delete(int codigo) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()) {
                funcionarios[i] = null;
            }
        }
        updateWriter();
    }

    public void updateWriter() {
        String path = "src/supermercado/arquivos/funcionarios.txt";
        String txt[] = new String[150];

        int numeroLinha = 0;

        for (int j = 0; j < funcionarios.length; j++) {
            if (funcionarios[j] != null) {
                txt[numeroLinha] = funcionarios[j].getNomeFuncionario();
                txt[numeroLinha + 1] = funcionarios[j].getCpfFuncionario();
                txt[numeroLinha + 2] = funcionarios[j].getLogin();
                txt[numeroLinha + 3] = funcionarios[j].getSenha();
                numeroLinha = numeroLinha + 4;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (int i =0; i < txt.length -1; i++) {
                if (txt[i] != null) {
                    bw.write(txt[i]);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void update(int codigo) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()) {
                Scanner scanner = new Scanner(System.in);
                String nome = scanner.nextLine();
                funcionarios[i].setNomeFuncionario(nome);
                String cpf = scanner.nextLine();
                funcionarios[i].setCpfFuncionario(cpf);
            }
        }
        updateWriter();
    }


    public boolean exists(int codigo) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()) {
                return true;
            }
        }
        return false;
    }
}