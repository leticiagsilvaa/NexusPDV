package supermercado.gui.telas;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import supermercado.gui.util.Alerts;
import supermercado.negocio.Fachada;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;

import java.io.IOException;


public class CadastrarFuncionariosController {

    @FXML
    private Button bt;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    public void onBtAction() {
        try {
            String nome = txt1.getText();
            String cpf = txt2.getText();
            String login = txt3.getText();
            String senha = txt4.getText();

            Fachada.getInstance().cadastrarFuncionario(new Funcionario(nome, cpf, new Login(login, senha)));
            Fachada.getInstance().cadastrarLogin(new Login(login, senha));

            String texto = "Funcionário cadastrado com sucesso";

            Alerts.showAlert("INFORMAÇÕES", "FUNCIONÁRIO", texto, Alert.AlertType.INFORMATION);
            abrirNovaTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void abrirNovaTela() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) bt.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }



}