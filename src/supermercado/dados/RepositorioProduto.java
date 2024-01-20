package supermercado.dados;

import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Produto;

import java.util.Arrays;
import java.util.Scanner;

public class RepositorioProduto implements IRepositorio<Produto>{
    private Produto produtos[];
    private int quantidadeProdutos;

    public RepositorioProduto(int numeroMaximo){
        produtos = new Produto[numeroMaximo];
        quantidadeProdutos = 0;
    }

    public Produto[] findByName(String nomeProd){
        Produto encontrado[] = new Produto[quantidadeProdutos];
        int produtoEncontrado = 0;

        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i] != null && name.equalsIgnoreCase(produtos[i].getNomeProd())) {
                encontrado[produtoEncontrado] = produtos[i];
                produtoEncontrado++;
            }
        }
        if(produtoEncontrado > 0){
            return Arrays.copyOf(encontrado, produtoEncontrado);
        }
        return null;
    };

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
        for (int i = 0; i < produtos.length; i++){
            if (produtos[i] != null && codigo == produtos[i].getCodigoProd()){
                return produtos[i];
            }
        }
        return null;
    }

    @Override
    public void add(Produto produto){
        if(quantidadeProdutos < produtos.length){
            produtos[quantidadeProdutos] = produto;
            quantidadeProdutos++;
        }
    }

    @Override
    public void delete(int codigo) {
        for(int i = 0; i < produtos.length; i++){
            if(produtos[i] != null && codigo == produtos[i].getCodigoProd()) {
                produtos[i] = null;
            }
        }
    }

    //falta implementar o método update e testar o repositório na classe main
}
