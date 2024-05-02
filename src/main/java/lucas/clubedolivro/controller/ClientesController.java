package lucas.clubedolivro.controller;

import lucas.clubedolivro.model.Clientes;
import lucas.clubedolivro.model.Livros;
import lucas.clubedolivro.model.dtos.ClientesDTO;
import lucas.clubedolivro.service.ClientesService;
import lucas.clubedolivro.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;
    @Autowired
    private LivrosService livrosService;

    @PostMapping("/cadastro")
    public ResponseEntity<Clientes> createClient(@RequestBody ClientesDTO clientesDTO){
        Clientes novoCliente = clientesService.createCliente(clientesDTO);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PostMapping("/comprar/{nomeLivro}")
    public ResponseEntity purchaseBook(@PathVariable String nomeLivro ){
        Optional<Livros> teste = livrosService.livroExiste(nomeLivro);
        String sucesso = "Livro '" + nomeLivro + "' encontrado com sucesso";
        if(teste.isEmpty()){
            sucesso = "Livro não encontrado!";
            return new ResponseEntity<>(sucesso, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teste, HttpStatus.OK);
    }

    @GetMapping("/cadastrados")
    public ResponseEntity<List<Clientes>> getAllClients(){
        return new ResponseEntity<>(clientesService.getAllClients(), HttpStatus.OK);
    }
}
