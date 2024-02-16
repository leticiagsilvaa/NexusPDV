package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import supermercado.gui.util.Alerts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class PagamentoValorController {

    @FXML
    private Label lbl;

    @FXML
    private Button btPagamento;

    @FXML
    private Button Load;

    @FXML
    private TextField txt;

    public void btAction(){
        lbl.setText(String.valueOf(lerArquivo()));
    }


    public void btRetirar() throws IOException {
        if(lbl.getText().equals("0.0")){
            Alerts.showAlert("INFORMAÇÕES", "Pagamento efetuado", "Imprimindo nota fiscal", Alert.AlertType.INFORMATION);
            //imprimir nota fiscal
            abrirNovaTela();
        }
        Double totalPago = Double.parseDouble(txt.getText());
        Double total = Double.parseDouble(lbl.getText());
        total = total - totalPago;
        lbl.setText(String.valueOf(total));

    }

    private Double lerArquivo(){
        try {
            Scanner scanner = new Scanner(new File("src/supermercado/arquivos/preco.txt"));
            Double preco = scanner.nextDouble();
            return preco;
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: ");
            e.printStackTrace();
            return null;
        }
    }

    private void abrirNovaTela() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("venda.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btPagamento.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}
