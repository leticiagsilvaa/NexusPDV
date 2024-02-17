package supermercado.dados;

import supermercado.dados.load.LoadProduto;
import supermercado.negocio.beans.Produto;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class RepositorioProduto {
    private Produto produtos[];
    private int quantidadeProdutos;

    private static RepositorioProduto instance;
    public RepositorioProduto(int numeroMaximo) {
        produtos = new Produto[numeroMaximo];
        quantidadeProdutos = 0;
    }

    public static RepositorioProduto getInstance() {
        if (instance == null) {
            instance = LoadProduto.cadastrarProdutos();
        }
        return instance;
    }

    public Produto[] findByName(String nomeProd) {
        Produto encontrado[] = new Produto[quantidadeProdutos];
        int produtoEncontrado = 0;

        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i] != null && nomeProd.equalsIgnoreCase(produtos[i].getNomeProd())) {
                encontrado[produtoEncontrado] = produtos[i];
                produtoEncontrado++;
            }
        }
        if (produtoEncontrado > 0) {
            return Arrays.copyOf(encontrado, produtoEncontrado);
        }
        return null;
    }

    public void tirarProduto(int codigo, int quantidade) {
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                produtos[i].setQuantidadeEstoque(produtos[i].getQuantidadeEstoque() - quantidade);
            }
        }
        updateWriter();
    }

    public Produto[] getAll() {
        for (Produto produto : produtos) {
            if (produto != null) {
                return Arrays.copyOf(produtos, quantidadeProdutos);
            }
        }
        return null;
    }

    public Produto getOne(int codigo) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                return produtos[i];
            }
        }
        return null;
    }

    public void add(Produto produto) {
        if (quantidadeProdutos < produtos.length) {
            produtos[quantidadeProdutos] = produto;
            quantidadeProdutos++;
        }
        updateWriter();
    }

    public void delete(int codigo) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                produtos[i] = null;
            }
        }
        updateWriter();
    }

    public void updateWriter() {
        String path = "src/supermercado/arquivos/produtos.txt";
        String txt[] = new String[200];

        int numeroLinha = 0;

        for (int j = 0; j < quantidadeProdutos; j++) {
            if (produtos[j] != null) {
                txt[numeroLinha] = String.valueOf(produtos[j].getCodigoProd());
                txt[numeroLinha + 1] = produtos[j].getNomeProd();
                txt[numeroLinha + 2] = produtos[j].getCategoriaProd();
                txt[numeroLinha + 3] = produtos[j].getValorProd().toString();
                txt[numeroLinha + 4] = String.valueOf(produtos[j].getQuantidadeEstoque());
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

    public void update(int codigo) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                String nome = scanner.nextLine();
                produtos[i].setNomeProd(nome);
                String categoria = scanner.nextLine();
                produtos[i].setCategoriaProd(categoria);
                Double valor = scanner.nextDouble();
                produtos[i].setValorProd(valor);
                int quantidade = scanner.nextInt();
                produtos[i].setQuantidadeEstoque(quantidade);
            }
        }
        updateWriter();
    }

    public boolean exists(int codigo) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                return true;
            }
        }
        return false;
    }

}