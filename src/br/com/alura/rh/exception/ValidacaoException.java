package br.com.alura.rh.exception;

public class ValidacaoException extends RuntimeException {

    public ValidacaoException(final String mensagem) {
        super(mensagem);
    }
}
