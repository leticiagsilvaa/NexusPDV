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
                String first_parameter = line;
                line = br.readLine();
                String second_parameter = line;
                line = br.readLine();
                String third_parameter = line;
                line = br.readLine();
                String fourth_parameter = line;
                repositorio.add(new Produto(Integer.parseInt(first_parameter), second_parameter, third_parameter, Double.parseDouble(fourth_parameter)));
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return repositorio;
    }
}
