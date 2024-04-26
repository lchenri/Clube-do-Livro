package lucas.clubedolivro.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/clientes")
public class ClientesController {

    @GetMapping
    public ResponseEntity<String> request(){
        String teste = "{oi. Tudo certo}";
        return new ResponseEntity<>(teste, HttpStatus.OK);
    }
}
