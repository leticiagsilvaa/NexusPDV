package supermercado.gui.telas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import supermercado.dados.RepositorioProduto;
import supermercado.gui.util.Alerts;

import java.io.IOException;
import java.util.Arrays;

public class MenuController {
    @FXML
    private Button send;
    @FXML
    private TextField textField;

    public void onBtAction() {
        try {
            String txt = textField.getText();
            if (txt.equals("2")) {
                abrirNovaTela("cancelamento.fxml");
            } else if (txt.equals("5")) {
                abrirNovaTela("fecharCaixa.fxml");
            } else if (txt.equals("6")) {
                abrirNovaTela("cadastrarFuncionario.fxml");
            }  else if (txt.equals("0")) {
                abrirNovaTela("venda.fxml");
            }  else if (txt.equals("4")) {
                System.out.println(Arrays.toString(RepositorioProduto.getInstance().getAll()));
            } else {
                Alerts.showAlert("Não encontrado", "Error", "Funcionalidade não implementada", Alert.AlertType.INFORMATION);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void abrirNovaTela(String tela) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(tela));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) send.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }


}
