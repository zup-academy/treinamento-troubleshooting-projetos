package br.com.zup.edu.badcustomers.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler( { DataAccessException.class, TransactionException.class })
    public ResponseEntity<?> handleDatabaseErrors(Exception ex, WebRequest request) {

        logger.error("Catching a database exception thrown by a controller: " + ex);

        Map<String, Object> body = Map.of(
                "status", 500,
                "error", "Internal Server Error",
                "path", request.getDescription(false).replace("uri=", ""),
                "timestamp", LocalDateTime.now(),
                "message", "ocorreu um erro interno. por favor contate o administrador."
        );
        return ResponseEntity
                .internalServerError().body(body);
    }
}
