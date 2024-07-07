package lucas.clubedolivro.controller;

import io.swagger.v3.oas.annotations.Operation;
import lucas.clubedolivro.model.livros.Livros;
import lucas.clubedolivro.model.livros.LivrosDTO;
import lucas.clubedolivro.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivrosController {

    @Autowired
    private LivrosService livrosService;

    @Operation(summary = "Registra um novo livro no sistema")
    @PostMapping("/create")
    public ResponseEntity<Livros> createLivro(@RequestBody LivrosDTO livrosDTO){
        Livros novoLivro = livrosService.createLivro(livrosDTO);
        return new ResponseEntity<>(novoLivro, HttpStatus.OK);
    }

    @Operation(summary = "Retorna os livros cadastrados no sistema")
    @GetMapping("/livroscadastrados")
    public ResponseEntity<List<Livros>> getAllLivros(){
        List<Livros> livros = livrosService.getAllLivros();
        return new ResponseEntity<>(livros, HttpStatus.ACCEPTED);
    }
}
