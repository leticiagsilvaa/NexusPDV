package supermercado.gui.telas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import supermercado.dados.RepositorioFuncionario;
import supermercado.dados.RepositorioVenda;
import supermercado.gui.util.Alerts;
import supermercado.negocio.beans.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class NotaFiscalController {

    @FXML
    private Label lbl;
    @FXML
    private Button Load;

    @FXML
    private Button btFinalizar;

    public void btLoad() throws IOException {
        int idVenda = lerId();
        System.out.println(idVenda);
//        Venda venda = RepositorioVenda.getInstance().getOne(idVenda);
//        System.out.println(venda);
//        int idCaixa = venda.getIdCaixa();
//        Funcionario funcionario = venda.getFuncionario();
//        List<Item> lista = venda.getListaItens();
//        NotaFiscal notaFiscal = new NotaFiscal(idCaixa, funcionario, lista);
//        notaFiscal.gerarNota(venda);
        abrirNovaTela("venda.fxml");
    }

    private int lerId() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/supermercado/arquivos/id.txt"));
        int id = scanner.nextInt();
        scanner.close();
        return id;
    }

    private void abrirNovaTela(String arquivo) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(arquivo));
        Parent root = loader.load();

        Scene scene = new Scene(root);

        Stage stage = (Stage) btFinalizar.getScene().getWindow();

        stage.setScene(scene);

        stage.show();
    }
}
