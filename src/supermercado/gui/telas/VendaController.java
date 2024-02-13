package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supermercado.dados.RepositorioProduto;
import supermercado.dados.load.LoadProduto;
import supermercado.negocio.beans.Produto;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;

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
            abrirNovaTela();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void searchProductCode(int codigo){
        RepositorioProduto repositorioProduto = LoadProduto.cadastrarProdutos();
        Produto produto = repositorioProduto.getOne(codigo);
        String quantidade = txt1.getText();
        lbl1.setText(produto.getNomeProd());
        lbl2.setText(String.valueOf(produto.getValorProd()));
        preco += produto.getValorProd() * Integer.parseInt(quantidade);
        lbl3.setText(String.valueOf(preco));
    }
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
