package supermercado;

import supermercado.negocio.beans.Funcionario;
import supermercado.negocio.beans.Login;
import supermercado.negocio.beans.Produto;

import java.time.LocalDate;

public class Main {
    public static void main(String args[]) {
        Login login = new Login("Luffy", "12345678");
        Funcionario funcionario = new Funcionario(login, "Luffy", "1234", "Rua das Flores, 87" );
        Produto produto = new Produto("Café", "Bebida", 2.50F);
        Produto produto2 = new Produto("Arroz", "Comida", 3.50F);
        System.out.println(produto.getCodigoProd());
        System.out.println(produto2.getCodigoProd());
        UI.modeloNotaFiscal(LocalDate.now(), funcionario, produto);
    }

}
