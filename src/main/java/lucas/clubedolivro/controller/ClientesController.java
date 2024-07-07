package lucas.clubedolivro.controller;

import io.swagger.v3.oas.annotations.Operation;
import lucas.clubedolivro.exception.ExceptionHandlerController;
import lucas.clubedolivro.model.clientes.Clientes;
import lucas.clubedolivro.model.livros.Livros;
import lucas.clubedolivro.model.clientes.ClientesDTO;
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

    @Operation(summary = "Cadastro de um novo cliente")
    @PostMapping("/cadastro")
    public ResponseEntity<Clientes> createClient(@RequestBody ClientesDTO clientesDTO){
        Clientes novoCliente = clientesService.createCliente(clientesDTO);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }


    @Operation(summary = "Registra a compra de um livro pelo cliente")
    @PostMapping("/comprar/{nomeCliente}/{nomeLivro}")
    public ResponseEntity purchaseBook(@PathVariable String nomeCliente, @PathVariable String nomeLivro){
        Optional<Livros> livro = livrosService.getThisLivro(nomeLivro);
        Optional<Clientes> cliente = clientesService.getThisCliente(nomeCliente);
        if(livro.isEmpty() || cliente.isEmpty()){
            return new ExceptionHandlerController().threatNullPointerException();
        }
        return clientesService.bookRegister(cliente.get(), livro.get());
    }

    @Operation(summary = "Retorna os clientes cadastrados no sistema")
    @GetMapping("/cadastrados")
    public ResponseEntity<List<Clientes>> getAllClients(){
        return new ResponseEntity<>(clientesService.getAllClients(), HttpStatus.OK);
    }

    @Operation(summary = "Retorna os livros comprados por um cliente")
    @GetMapping("/livrosComprados/{clienteId}")
    public ResponseEntity<List<Livros>> getAllLivros(@PathVariable Long clienteId){
        if(livrosService.getLivrosByCliente(clienteId).isEmpty()) return ResponseEntity.badRequest().build();
        return new ResponseEntity(livrosService.getLivrosByCliente(clienteId), HttpStatus.OK);
    }

}
