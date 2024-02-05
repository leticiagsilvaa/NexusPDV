package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class VendaController {

    @FXML
    private Button bt;

    public void onBtAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) bt.getScene().getWindow();
        stage.close();
    }
}
