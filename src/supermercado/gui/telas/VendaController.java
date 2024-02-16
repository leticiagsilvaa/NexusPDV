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
import supermercado.dados.load.LoadFuncionario;
import supermercado.dados.load.LoadProduto;
import supermercado.dados.load.LoadVenda;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Produto;
import supermercado.negocio.beans.Venda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

            if(codigo.equals("m")){
                abrirNovaTelaMenu();
            } else {
                searchProductCode(Integer.parseInt(codigo));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBtFinalizarAction(){
        try{
            String preco = lbl3.getText();
            RepositorioVenda repositorioVenda = new RepositorioVenda(1000);
            repositorioVenda.precoTotalWriter(preco);
            abrirNovaTela();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void searchProductCode(int codigo) {
        DecimalFormat df = new DecimalFormat("0.00");
        RepositorioProduto repositorioProduto = LoadProduto.cadastrarProdutos();
        RepositorioFuncionario funcionario = LoadFuncionario.cadastrarFuncionarios();

        Produto produto = repositorioProduto.getOne(codigo);
        List<Integer> itens = new ArrayList<>();
        itens.add(produto.getCodigoProd());

        String quantidade = txt1.getText();

        if(produto.getQuantidadeEstoque() < Integer.parseInt(quantidade)){
            throw new RuntimeException("Venda impossível");
        }

        produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - Integer.parseInt(quantidade));
        lbl1.setText(produto.getNomeProd());
        lbl2.setText(String.valueOf(produto.getValorProd()));

        preco += produto.getValorProd() * Integer.parseInt(quantidade);
        String precoFormatado = df.format(preco);
        lbl3.setText(String.valueOf(precoFormatado));
        lbl4.setText(itens.toString());

        //Venda venda = new Venda(lerId(), funcionario.getOne(lerCodigo()));
        //venda.adicionarItemLista(produto, Integer.parseInt(quantidade));
        }


    private int lerId() {
        String path = "src/supermercado/arquivos/venda.txt";
        int id = 0;
        int codigo = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                id = Integer.parseInt(line);
                br.readLine();
                codigo = Integer.parseInt(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return id;
    };

    private int lerCodigo() {
        String path = "src/supermercado/arquivos/venda.txt";
        int id = 0;
        int codigo = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                id = Integer.parseInt(line);
                br.readLine();
                codigo = Integer.parseInt(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return codigo;
    };

    private void abrirNovaTelaMenu() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btPesquisar.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    private void abrirNovaTela() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pagamento.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btPesquisar.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }


}
