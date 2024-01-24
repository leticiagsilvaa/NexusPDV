package supermercado.dados;

import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RepositorioProduto implements IRepositorio<Produto> {
    private Produto produtos[];
    private int quantidadeProdutos;

    public RepositorioProduto(int numeroMaximo) {
        produtos = new Produto[numeroMaximo];
        quantidadeProdutos = 0;
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

    ;

    @Override
    public Produto[] getAll() {
        for (Produto produto : produtos) {
            if (produto != null) {
                return Arrays.copyOf(produtos, quantidadeProdutos);
            }
        }
        return null;
    }

    @Override
    public Produto getOne(int codigo) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                return produtos[i];
            }
        }
        return null;
    }

    @Override
    public void add(Produto produto) {
        if (quantidadeProdutos < produtos.length) {
            produtos[quantidadeProdutos] = produto;
            quantidadeProdutos++;
        }
        updateWriter();
    }

    @Override
    public void delete(int codigo) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                produtos[i] = null;
            }
        }
        updateWriter();
    }

    public void updateWriter() {
        String path = "src/supermercado/arquivos/produtosAtualizados.txt";
        String txt[] = new String[150];

        int numeroLinha = 0;

        for (int j = 0; j < produtos.length; j++) {
            if (produtos[j] != null) {
                txt[numeroLinha] = produtos[j].getNomeProd();
                txt[numeroLinha + 1] = produtos[j].getCategoriaProd();
                txt[numeroLinha + 2] = produtos[j].getValorProd().toString();
                numeroLinha = numeroLinha + 3;
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
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                String nome = scanner.nextLine();
                produtos[i].setNomeProd(nome);
                String categoria = scanner.nextLine();
                produtos[i].setCategoriaProd(categoria);
                Double valor = scanner.nextDouble();
                produtos[i].setValorProd(valor);
            }
        }
        updateWriter();
    }

}
