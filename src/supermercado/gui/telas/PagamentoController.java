package supermercado.gui.telas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class PagamentoController {
    @FXML
    private Button dinheiro;
    @FXML
    private Button cartaoDebito;
    @FXML
    private Button cartaoCredito;
    @FXML
    private Button pix;

    public void onBtAction(){
        try {
            abrirNovaTela();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void abrirNovaTela() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("pagamento_valor.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) dinheiro.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }


}
