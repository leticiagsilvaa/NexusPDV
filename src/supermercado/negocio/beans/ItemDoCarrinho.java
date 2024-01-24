package supermercado.negocio.beans;

public class ItemDoCarrinho {

    private Produto produto;
    private int quantidadeItem;

    public ItemDoCarrinho(Produto produto, int quantidadeItem) {
        this.produto = produto;
        this.quantidadeItem = quantidadeItem;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public Double calcularValorParcial(){
        return produto.getValorProd() * quantidadeItem;
    }

    @Override
    public String toString() {
        return "Produto: " + produto + "\n" +
                "Quantidade do Produto: " + quantidadeItem + "\n";
    }
}
