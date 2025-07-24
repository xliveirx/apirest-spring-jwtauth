package br.com.joao.booksapirest.api.exceptions;

public class ApplicationException extends RuntimeException{

    public ApplicationException(String message) {
        super(message);
    }
}
