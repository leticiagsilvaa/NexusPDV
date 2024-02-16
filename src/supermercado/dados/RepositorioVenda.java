package supermercado.dados;

import supermercado.negocio.beans.Venda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class RepositorioVenda {
    private Venda vendas[];
    private int quantidadeVendas;

    public RepositorioVenda(int numeroMaximo) {
        vendas = new Venda[numeroMaximo];
        quantidadeVendas = 0;
    }

    ;

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
        updateWriter();
    }

    public void delete(int codigo) {
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null && codigo == vendas[i].getIdVenda()) {
                vendas[i] = null;
            }
        }
        updateWriter();
    }

    public void idWriter(String id, String codigo){
        String path = "src/supermercado/arquivos/dadosTemporarios.txt";
        String txt[] = new String[1000];

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

    public void precoTotalWriter(String preco){
        String path = "src/supermercado/arquivos/dadosTemporarios.txt";
        String txt[] = new String[3];

        txt[2] = preco;

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
