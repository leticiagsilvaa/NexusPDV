package supermercado.dados;

import supermercado.negocio.beans.Login;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RepositorioLogin {

    //private static RepositorioLogin instance;
    private int quantidadeLogins;
    private Login logins[];

    public RepositorioLogin(int numeroMaximo) {
        logins = new Login[numeroMaximo];
        quantidadeLogins = 0;
    }

    /*

    public static RepositorioLogin getInstance() {
        if (instance == null) {
            instance = lerDoArquivo();
        }
        salvarArquivo();
        return instance;
    }

    private static RepositorioLogin lerDoArquivo() {
        RepositorioLogin instanciaLocal = null;

        File in = new File("login.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            instanciaLocal = (RepositorioLogin) o;
        } catch (Exception e) {
            instanciaLocal = new RepositorioLogin(100);
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {/* Silent exception */
    /*
                }
            }
        }

        return instanciaLocal;
    }

    public static void salvarArquivo() {
        if (instance == null) {
            return;
        }
        File out = new File("login.dat");
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
                    Silent
                }
            }
        }
    }
    */


    public Login getAll() {
        System.out.println(Arrays.toString(logins));
        for (Login log : logins) {
            if (log != null && quantidadeLogins > 0) {
                return log;
            }
        }
        return null;
    }


    public Login getOne(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                return logins[i];
            }
        }
        return null;
    }


    public String loginMatch(Login login) {
        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login.equals(logins[i])) {
                return logins[i].getLogin();
            }
        }
        throw new RuntimeException("Login ou senha incorretos. Tente novamente");
    }

    public Login findByUser(String login) {
        for (int i = 0; i < quantidadeLogins; i++) {
            if (logins[i] != null && login.equals(logins[i].getLogin())) {
                return logins[i];
            }
        }
        return null;
    }

    public void add(Login login) {
        if (quantidadeLogins < logins.length) {
            logins[quantidadeLogins] = login;
            quantidadeLogins++;
        }
    }


    public void delete(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                logins[i] = null;
            }
        }
    }

    public void updateWriter() {
        String path = "src/supermercado/arquivos/loginTeste.txt";
        String txt[] = new String[150];

        int numeroLinha = 0;

        for (int j = 0; j < logins.length; j++) {
            if (logins[j] != null) {
                txt[numeroLinha] = logins[j].getLogin();
                txt[numeroLinha + 1] = logins[j].getSenha();
                numeroLinha = numeroLinha + 2;
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

    }
    public boolean exists(int codigo) {
        for (int i = 0; i < logins.length; i++) {
            if (logins[i] != null && codigo == logins[i].getCodigo()) {
                return true;
            }
        }
        return false;
    }
}