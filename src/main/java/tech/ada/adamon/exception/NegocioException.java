package tech.ada.adamon.exception;

public class NegocioException extends RuntimeException {

    private String mensagem;

    public NegocioException(String message) {
        super(message);
        this.mensagem = message;
    }

}
