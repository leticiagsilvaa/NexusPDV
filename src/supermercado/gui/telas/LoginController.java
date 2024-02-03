package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioLogin;
import supermercado.dados.load.LoadFuncionario;
import supermercado.dados.load.LoadLogin;
import supermercado.gui.util.Alerts;
import supermercado.negocio.CadastroFuncionario;
import supermercado.negocio.CadastroLogin;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;


public class LoginController {

    @FXML
    private Button btTest;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private PasswordField txt3;

    @FXML
    public void onBtTestAction() {
        try {
            String caixa = txt1.getText();
            String login = txt2.getText();
            String senha = txt3.getText();

            RepositorioFuncionario repositorioFuncionario = LoadFuncionario.cadastrarFuncionarios();
            RepositorioLogin repositorioLogin = LoadLogin.cadastrarLogins();

            String user_funcionario = repositorioLogin.loginMatch(new Login(login, senha));

            Funcionario funcionario = repositorioFuncionario.findByUser(user_funcionario);

            String texto = "Caixa " + caixa + " aberto " + "\nAtendido pelo funcionário " + funcionario.getNomeFuncionario() + "\nCódigo: " + funcionario.getCodigoFuncionario();

            Alerts.showAlert("INFORMAÇÕES", "FUNCIONÁRIO", texto, Alert.AlertType.INFORMATION);
            abrirNovaTela();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void abrirNovaTela() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("venda.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btTest.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}