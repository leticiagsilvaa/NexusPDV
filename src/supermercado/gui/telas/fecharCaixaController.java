package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import supermercado.gui.util.Alerts;
import supermercado.negocio.Fachada;

import java.io.IOException;

public class fecharCaixaController {
    @FXML
    private Button btCancelar;

    @FXML
    private Button btFinalizar;

    @FXML
    private PasswordField password;

    public void onBtCadastrarAction() {
        try {
            String pass = password.getText();
            String texto = "Caixa finalizado";

            Alerts.showAlert("INFORMAÇÕES", "CAIXA FINALIZADO", texto, Alert.AlertType.INFORMATION);
            abrirNovaTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onBtCancelarAction() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btFinalizar.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

    private void abrirNovaTela() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btFinalizar.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }

}
