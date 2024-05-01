package lucas.clubedolivro.controller;

import lucas.clubedolivro.model.Livros;
import lucas.clubedolivro.model.dtos.LivrosDTO;
import lucas.clubedolivro.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @PostMapping
    public ResponseEntity<Livros> createLivro(@RequestBody LivrosDTO livrosDTO){
        Livros novoLivro = livrosService.createLivro(livrosDTO);
        return new ResponseEntity<>(novoLivro, HttpStatus.ACCEPTED);
    }
}
