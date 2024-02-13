package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supermercado.gui.util.Alerts;
import supermercado.negocio.Fachada;
import supermercado.negocio.beans.Produto;

import java.io.IOException;

public class cadastrarProdutoController {
    @FXML
    private Button btCancelar;

    @FXML
    private Button btCadastrar;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    public void onBtCadastrarAction() {
        try {
            String codigo = txt1.getText();
            String nome = txt2.getText();
            String categoria = txt3.getText();
            String valor = txt4.getText();
            String quantidade = txt5.getText();

            //Fachada.getInstance().cadastrarProdutos(new Produto(nome,categoria, Double.parseDouble(valor)));

            String texto = "Produto cadastrado com sucesso";

            Alerts.showAlert("INFORMAÇÕES", "FUNCIONÁRIO", texto, Alert.AlertType.INFORMATION);
            abrirNovaTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBtCancelarAction() {
        try {
            abrirNovaTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirNovaTela() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btCadastrar.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

}
