package supermercado.dados;

import supermercado.negocio.beans.Venda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class RepositorioVenda implements IRepositorio<Venda> {
    private Venda vendas[];
    private int quantidadeVendas;

    public RepositorioVenda(int numeroMaximo) {
        vendas = new Venda[numeroMaximo];
        quantidadeVendas = 0;
    }

    ;

    @Override
    public Venda[] getAll() {
        for (Venda venda : vendas) {
            if (venda != null) {
                return Arrays.copyOf(vendas, quantidadeVendas);
            }
        }
        return null;
    }

    @Override
    public Venda getOne(int codigo) {
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null && codigo == vendas[i].getIdVenda()) {
                return vendas[i];
            }
        }
        return null;
    }

    @Override
    public void add(Venda venda) {
        if (quantidadeVendas < vendas.length) {
            vendas[quantidadeVendas] = venda;
            quantidadeVendas++;
        }
        updateWriter();
    }

    @Override
    public void delete(int codigo) {
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null && codigo == vendas[i].getIdVenda()) {
                vendas[i] = null;
            }
        }
        updateWriter();
    }

    public void updateWriter() {
        String path = "src/supermercado/arquivos/vendasTeste.txt";
        String txt[] = new String[1000];

        int numeroLinha = 0;

        for (int j = 0; j < vendas.length; j++) {
            if (vendas[j] != null) {
                txt[numeroLinha] = String.valueOf(vendas[j].getIdVenda());
                txt[numeroLinha + 1] = vendas[j].getFuncionario().getNomeFuncionario();
                txt[numeroLinha + 2] = String.valueOf(vendas[j].getSubtotal());
                txt[numeroLinha + 3] = String.valueOf(vendas[j].getListaItens());
                txt[numeroLinha + 4] = String.valueOf(vendas[j].getTroco());
                numeroLinha = numeroLinha + 5;
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

    @Override
    public void update(int codigo) {

    }

    @Override
    public boolean exists(int codigo) {
        for (int i = 0; i < vendas.length; i++) {
            if (vendas[i] != null && codigo == vendas[i].getIdVenda()) {
                return true;
            }
        }
        return false;
    }
}
