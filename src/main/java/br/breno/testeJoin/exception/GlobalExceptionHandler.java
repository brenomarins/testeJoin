package br.breno.testeJoin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<ErroCustomizado> handleRuntime(RuntimeException ex) {
        log.error("Resource not found: {}", ex.getMessage());
        ErroCustomizado err = new ErroCustomizado(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Recurso não encontrado", ex.getMessage());
        return ResponseEntity.badRequest().body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroCustomizado> erroGenerico(Exception e) {
        log.error("An unexpected error occurred: {}", e.getMessage(), e);
        ErroCustomizado err = new ErroCustomizado(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", "Ocorreu um erro interno no servidor");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

}
