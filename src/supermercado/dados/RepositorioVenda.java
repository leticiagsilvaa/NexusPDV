package supermercado.dados;

import supermercado.dados.load.LoadProduto;
import supermercado.dados.load.LoadVenda;
import supermercado.negocio.beans.Produto;
import supermercado.negocio.beans.Venda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class RepositorioVenda {
    private Venda vendas[];
    private int quantidadeVendas;

    private static RepositorioVenda instance;

    public RepositorioVenda(int numeroMaximo) {
        vendas = new Venda[numeroMaximo];
        quantidadeVendas = 0;
    }

    public static RepositorioVenda getInstance() {
        if (instance == null) {
            instance = LoadVenda.cadastrarVenda();
        }
        return instance;
    }

    public Venda[] getAll() {
        for (Venda venda : vendas) {
            if (venda != null) {
                return Arrays.copyOf(vendas, quantidadeVendas);
            }
        }
        return null;
    }

    public Venda getOne(int codigo) {
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null && codigo == vendas[i].getIdVenda()) {
                return vendas[i];
            }
        }
        return null;
    }

    public void add(Venda venda) {
        if (quantidadeVendas < vendas.length) {
            vendas[quantidadeVendas] = venda;
            quantidadeVendas++;
        }
    }

    public void delete(int codigo) {
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null && codigo == vendas[i].getIdVenda()) {
                vendas[i] = null;
            }
        }
        updateWriter();
    }

    public void idWriter(String id, String codigo) {
        String path = "src/supermercado/arquivos/dadosTemporarios.txt";
        String txt[] = new String[10];

        int dados[] = new int[2];
        dados[0] = Integer.parseInt(id);
        dados[1] = Integer.parseInt(codigo);

        int numeroLinha = 0;

        txt[numeroLinha] = id;
        txt[numeroLinha + 1] = codigo;

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

    public void precoTotalWriter(String preco) {
        String path = "src/supermercado/arquivos/preco.txt";
        String txt[] = new String[1];

        txt[0] = preco;

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

    public void updateWriter() {
        String path = "src/supermercado/arquivos/venda.txt";
        String txt[] = new String[1000];

        int numeroLinha = 0;

        for (int j = 0; j < vendas.length; j++) {
            if (vendas[j] != null) {
                txt[numeroLinha] = String.valueOf(vendas[j].getIdVenda());
                txt[numeroLinha + 1] = String.valueOf(vendas[j].getFuncionario());
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
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null && codigo == vendas[i].getIdVenda()) {
                return true;
            }
        }
        return false;
    }
}
