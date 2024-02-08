package supermercado.dados;

import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;

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
            instance = lerDoArquivo();
        }
        return instance;
    }

    private static RepositorioFuncionario lerDoArquivo() {
        RepositorioFuncionario instanciaLocal = null;

        File in = new File("funcionarios.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioFuncionario) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioFuncionario(100);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
                }
            }
        }

        return instanciaLocal;
    }

    public void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("funcionarios.txt");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(out);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(instance);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    /* Silent */
                }
            }
        }
    }


    public Funcionario[] getAll() {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario != null && quantidadeFuncionarios > 0) {
                return Arrays.copyOf(funcionarios, quantidadeFuncionarios);
            }
        }
        return null;
    }

    ;


    public Funcionario getOne(int codigo) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null && codigo == funcionarios[i].getCodigoFuncionario()) {
                return funcionarios[i];
            }
        }
        return null;
    }

    ;

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

    ;

    public Funcionario findByUser(String login) {
        for (int i = 0; i < quantidadeFuncionarios; i++) {
            if (funcionarios[i] != null && funcionarios[i].getLogin().equals(login)) {
                return funcionarios[i];
            }
        }
        return null;
    }

    ;


    public void add(Funcionario funcionario) {
        if (quantidadeFuncionarios < funcionarios.length) {
            funcionarios[quantidadeFuncionarios] = funcionario;
            quantidadeFuncionarios++;
        }
        updateWriter();
    }

    ;


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
        String txt[] = new String[50];

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
            for (String linha : txt) {
                if (linha != null) {
                    bw.write(linha);
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