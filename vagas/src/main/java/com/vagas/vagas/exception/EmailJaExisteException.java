package com.vagas.vagas.exception;

public class EmailJaExisteException extends RuntimeException{

    public EmailJaExisteException(String mensagem){
        super(mensagem);
    }
}
