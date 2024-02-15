package supermercado.dados.load;

import supermercado.dados.RepositorioProduto;
import supermercado.negocio.beans.Produto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoadProduto {
    public static RepositorioProduto cadastrarProdutos(){

        RepositorioProduto repositorio = new RepositorioProduto(50);

        String path_produtos = "src/supermercado/arquivos/produtos.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path_produtos))) {
            String line = br.readLine();

            while (line != null) {
                String nome = line;
                line = br.readLine();
                String categoria = line;
                line = br.readLine();
                double valor = Double.parseDouble(line);
                line = br.readLine();
                int quantidade = Integer.parseInt(line);

                Produto produto = new Produto(nome, categoria, valor, quantidade);
                repositorio.add(produto, quantidade);

                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return repositorio;
    }
}
