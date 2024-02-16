package supermercado.negocio.beans;

public class Produto {
    private String nomeProd;
    private int codigoProd;
    private String categoriaProd;
    private Double valorProd;
    private int quantidadeEstoque;
    public Produto(int codigoProd,String nomeProd, String categoriaProd, Double valorProd, int quantidadeEstoque){
        this.codigoProd = codigoProd;
        this.nomeProd = nomeProd;
        this.categoriaProd = categoriaProd;
        this.valorProd = valorProd;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getValorProd() {
        return valorProd;
    }

    public int getCodigoProd() {
        return codigoProd;
    }

    public String getCategoriaProd() {
        return categoriaProd;
    }
    public String getNomeProd() {
        return nomeProd;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void setValorProd(Double valorProd) {
        this.valorProd = valorProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    @Override
    public String toString() {
        return   nomeProd + "\n" +
                "Categoria: " + categoriaProd + "\n" +
                "Valor: " + valorProd + "\n" +
                "Quantidade: " + quantidadeEstoque + "\n";

    }
}

