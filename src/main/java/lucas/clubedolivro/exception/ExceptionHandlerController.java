package lucas.clubedolivro.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity threatNullPointerException(){
        ExceptionBookNotFound bookNotFound = new ExceptionBookNotFound("Livro ou cliente não encontrado", "400");
        return ResponseEntity.badRequest().body(bookNotFound);
    }

}
