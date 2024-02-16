package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioProduto;
import supermercado.dados.RepositorioVenda;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Produto;
import supermercado.negocio.beans.Venda;

import java.io.*;
import java.text.DecimalFormat;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendaController {
    double preco = 0;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Button btFinalizar;

    @FXML
    private Button btPesquisar;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;


    @FXML
    public void onBtTestAction() {
        try {
            String codigo = txt2.getText();

            if (codigo.equals("m")) {
                abrirNovaTela("menu.fxml");
            } else {
                searchProductCode(Integer.parseInt(codigo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBtFinalizarAction() {
        try {
            String preco = lbl3.getText();
            RepositorioVenda.getInstance().precoTotalWriter(preco);
            abrirNovaTela("pagamento.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchProductCode(int codigoProduto) {
        DecimalFormat df = new DecimalFormat("0.00");

        Produto produto = RepositorioProduto.getInstance().getOne(codigoProduto);
        int[] dadosArquivo = lerArquivo();
        int id = dadosArquivo[0];
        int codigoFuncionario = dadosArquivo[1];
        System.out.println(id + "" + codigoFuncionario);

        Funcionario funcionario = RepositorioFuncionario.getInstance().getOne(codigoFuncionario);
        List<Produto> itens = new ArrayList<>();
        itens.add(produto);

        String quantidade = txt1.getText();

        if (produto.getQuantidadeEstoque() < Integer.parseInt(quantidade)) {
            throw new RuntimeException("Venda impossível");
        }

        RepositorioProduto.getInstance().tirarProduto(produto.getCodigoProd(), Integer.parseInt(quantidade));
        lbl1.setText(produto.getNomeProd());
        lbl2.setText(String.valueOf(produto.getValorProd()));

        preco += produto.getValorProd() * Integer.parseInt(quantidade);
        String precoFormatado = df.format(preco);
        lbl3.setText(String.valueOf(precoFormatado));
        lbl4.setText(itens.toString());

        Venda venda = new Venda(id, funcionario);
        venda.setListaItens(itens);
    }

    private int[] lerArquivo(){
        try {
            Scanner scanner = new Scanner(new File("src/supermercado/arquivos/dadosTemporarios.txt"));
            int id = scanner.nextInt();
            int codigo = scanner.nextInt();
            scanner.close();
            int[] i = {id,codigo};
            return i;
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: ");
            e.printStackTrace();
            return null;
        }
    }

    private void abrirNovaTela(String arquivo) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(arquivo));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btPesquisar.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}
