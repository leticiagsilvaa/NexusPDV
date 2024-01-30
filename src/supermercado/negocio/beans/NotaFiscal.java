package supermercado.negocio.beans;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NotaFiscal {
    private int idNotaFiscal;
    private int idCaixa;
    private String loginFuncionario;
    private List<Item> itens;
    private Date dataEmissao;

    public NotaFiscal(int idCaixa, String loginFuncionario, List<Item> itens) {
        this.idCaixa = idCaixa;
        this.loginFuncionario = loginFuncionario;
        this.itens = itens;
        this.dataEmissao = new Date();
    }

    public void gerarNota(Venda venda) {
        this.idNotaFiscal = venda.getIdVenda();  // Usando o ID da venda como ID da nota fiscal (pode ajustar conforme necessário)

        System.out.println("NexusPDV");
        System.out.println("-----------------------------");
        System.out.println("Nota Fiscal");
        System.out.println("ID Nota Fiscal: " + idNotaFiscal);
        System.out.println("ID Caixa: " + idCaixa);
        System.out.println("Nome do Funcionário: "  + loginFuncionario);
        System.out.println("Data Emissão: " + formatarData(dataEmissao));
        System.out.println("Itens:");
        for (Item item : itens) {
            System.out.println(item);
        }
        System.out.println("Total: " + venda.calcularTotal());
    }

    private String formatarData(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(data);
    }

}
