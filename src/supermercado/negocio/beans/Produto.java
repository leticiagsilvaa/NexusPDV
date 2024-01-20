package supermercado.negocio.beans;

public class Produto {
    private String nomeProd;
    private static int codigoProd = 0;
    private String categoriaProd;
    private float valorProd;

    public Produto(String nomeProd, String categoriaProd, float valorProd){
        Produto.codigoProd++;
        this.nomeProd = nomeProd;
        this.categoriaProd = categoriaProd;
        this.valorProd = valorProd;
    }

    public float getValorProd() {
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

    public void setValorProd(float valorProd) {
        this.valorProd = valorProd;
    }
}
