package supermercado.negocio.beans;

public class Produto {
    private String nomeProd;
    private int codigoProd;
    private String categoriaProd;
    private Double valorProd;
    private static int totalProdutos = 0;

    public Produto(String nomeProd, String categoriaProd, Double valorProd){
        this.codigoProd = gerarNovoCodigo();
        this.nomeProd = nomeProd;
        this.categoriaProd = categoriaProd;
        this.valorProd = valorProd;
    }

    private int gerarNovoCodigo(){
        return ++totalProdutos;
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
                "Valor: " + valorProd + "\n";
    }
}

