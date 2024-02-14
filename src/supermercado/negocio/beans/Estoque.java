package supermercado.negocio.beans;
import supermercado.dados.RepositorioProduto;
import java.util.Arrays;

public class Estoque {


    private RepositorioProduto repositorioProduto;

    public Estoque(RepositorioProduto repositorioProduto) {
        this.repositorioProduto = repositorioProduto;
    }

    public void adicionarProdutoAoEstoque(Produto produto, int quantidade) {
        Produto produtoExistente = repositorioProduto.getOne(produto.getCodigoProd());

        if (produtoExistente != null) {

            produtoExistente.setQuantidadeEstoque(produtoExistente.getQuantidadeEstoque() + quantidade);
            repositorioProduto.update(produtoExistente.getCodigoProd());
        } else {

            produto.setQuantidadeEstoque(quantidade);
            repositorioProduto.add(produto);
        }
    }

    public void removerProdutoDoEstoque(int codigoProduto, int quantidade) {
        Produto produtoExistente = repositorioProduto.getOne(codigoProduto);

        if (produtoExistente != null) {

            int novaQuantidade = produtoExistente.getQuantidadeEstoque() - quantidade;

            if (novaQuantidade <= 0) {

                repositorioProduto.delete(codigoProduto);
            } else {

                produtoExistente.setQuantidadeEstoque(novaQuantidade);
                repositorioProduto.update(codigoProduto);
            }
        }
    }

    public void listarProdutosNoEstoque() {
        System.out.println("Produtos no Estoque:");
        Produto[] produtos = repositorioProduto.getAll();

        if (produtos != null && produtos.length > 0) {
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        } else {
            System.out.println("Estoque vazio.");
        }
    }



}
