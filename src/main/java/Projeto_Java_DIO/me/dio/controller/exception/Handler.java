package Projeto_Java_DIO.me.dio.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.rmi.UnexpectedException;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class Handler {

    private final Logger logger = LoggerFactory.getLogger(Handler.class);

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIlegal(IllegalArgumentException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handlenosuch(NoSuchElementException notexception){
        return new ResponseEntity<>("ID nao encontrado", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handle(Throwable tronotexception){
        var mensagem = "ERRO, verificar logs";
        logger.error(mensagem, tronotexception);
        return new ResponseEntity<>("Erro no servidor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
