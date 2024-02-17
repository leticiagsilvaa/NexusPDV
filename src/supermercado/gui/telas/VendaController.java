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
import supermercado.negocio.beans.Item;
import supermercado.negocio.beans.Produto;
import supermercado.negocio.beans.Venda;

import java.io.*;
import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
        Locale.setDefault(Locale.US);
        try {
            String preco = lbl3.getText().trim();
            RepositorioVenda.getInstance().precoTotalWriter(preco);
            if (preco.isEmpty()) {
                try {
                    throw new RuntimeException("Texto vazio");
                } catch (RuntimeException e) {
                    throw new RuntimeException(e);
                }
            }
            Double precoAjustado = Double.parseDouble(preco);

            if (precoAjustado <= 0) {
                System.out.println("O preço não é válido.");
                return;
            }

            int id = lerId();
            System.out.println(id);
            Venda venda = RepositorioVenda.getInstance().getOne(id);
            //venda.setSubtotal(precoAjustado);
            abrirNovaTela("pagamento.fxml");

        } catch (NumberFormatException e) {
            System.out.println("Formato inválido para o preço.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchProductCode(int codigoProduto) {
        Locale.setDefault(Locale.US);
        DecimalFormat df = new DecimalFormat("0.00");

        Produto produto = RepositorioProduto.getInstance().getOne(codigoProduto);
        int[] dadosArquivo = lerArquivo();
        int id = dadosArquivo[0];
        int codigoFuncionario = dadosArquivo[1];
        System.out.println(id + "" + codigoFuncionario);

        String quantidade = txt1.getText();

        Funcionario funcionario = RepositorioFuncionario.getInstance().getOne(codigoFuncionario);
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(produto, Integer.parseInt(quantidade)));

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
        RepositorioVenda.getInstance().idVendaWriter(String.valueOf(venda.getIdVenda()));
        venda.adicionarItemLista(produto, Integer.parseInt(quantidade));
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

    private int lerId(){
        try {
            Scanner scanner = new Scanner(new File("src/supermercado/arquivos/id.txt"));
            int id = scanner.nextInt();
            scanner.close();
            int i = id;
            return i;
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: ");
            e.printStackTrace();
            return 0;
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
