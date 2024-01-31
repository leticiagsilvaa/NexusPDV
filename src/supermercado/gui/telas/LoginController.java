package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioLogin;
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

            RepositorioFuncionario repositorioFuncionario = CadastroFuncionario.cadastrarFuncionarios();
            RepositorioLogin repositorioLogin = CadastroLogin.cadastrarLogins();

            String user_funcionario = repositorioLogin.loginMatch(new Login(login, senha));

            Funcionario funcionario = repositorioFuncionario.findByUser(user_funcionario);

            String texto = "Caixa aberto de número: " + caixa + " atendido pelo funcionário " + funcionario.getNomeFuncionario() + " de código " + funcionario.getCodigoFuncionario();

            Alerts.showAlert("INFORMAÇÕES", "FUNCIONÁRIO", texto, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}