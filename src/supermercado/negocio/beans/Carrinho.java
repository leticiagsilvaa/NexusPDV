package supermercado.negocio.beans;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private int codigo;
    private static int ContadorCodigo = 0;
    private List<ItemDoCarrinho> itens;
    private Double total;

    public Carrinho(int codigo, List<ItemDoCarrinho> itens, Double total) {
        this.codigo = setCodigo();
        this.itens = new ArrayList<>();
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public int setCodigo() {
        return ContadorCodigo++;
    }

    public List<ItemDoCarrinho> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoCarrinho> itens) {
        this.itens = itens;
    }

    public Double getTotal() {
        Double tots = 0.0;
        for (ItemDoCarrinho item : itens) {
            tots += item.calcularValorParcial();
        }
        return tots;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + "\n" +
                "Itens: " + itens + "\n" +
                "Total: " + total + "\n";
    }
}
