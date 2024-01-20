package supermercado;

import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Produto;

import java.time.LocalDate;

public class UI {
    public static void modeloNotaFiscal(LocalDate data, Funcionario funcionario, Produto produto){
        System.out.printf("Data da Venda: " + data + "\n" +
        "Atendente: "+ funcionario.getNomeFuncionario() + "\n" + "\n" +
        "Nome do produto: " + produto.getNomeProd() + "\n" +
        "Preço : " + produto.getValorProd() + "\n" +
                "-----------------------------------------------------\n"+

               "Total da Venda: 			               R$  ");
    }

}
