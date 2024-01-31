package supermercado.gui.telas;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioLogin;
import supermercado.gui.util.Alerts;
import supermercado.negocio.CadastroFuncionario;
import supermercado.negocio.CadastroLogin;
import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;


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
            RepositorioFuncionario repositorioFuncionario = CadastroFuncionario.cadastrarFuncionarios();
            RepositorioLogin repositorioLogin = CadastroLogin.cadastrarLogins();

            String nome = txt1.getText();
            String cpf = txt2.getText();
            String login = txt3.getText();
            String senha = txt4.getText();

            repositorioFuncionario.add(new Funcionario(nome, cpf, new Login(login, senha)));
            repositorioLogin.add(new Login(login, senha));

            String texto = "Funcionário cadastrado com sucesso";

            Alerts.showAlert("INFORMAÇÕES", "FUNCIONÁRIO", texto, Alert.AlertType.INFORMATION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}