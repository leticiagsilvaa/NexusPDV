public class PagamentoCartaoException extends PagamentoException {
    public MinhaClasseException(String message) {
        super("O número do cartão não pode estar vazio.");
    }
}
