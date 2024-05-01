package lucas.clubedolivro.controller;

import lucas.clubedolivro.model.Clientes;
import lucas.clubedolivro.model.dtos.ClientesDTO;
import lucas.clubedolivro.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public ResponseEntity<Clientes> createClient(@RequestBody ClientesDTO clientesDTO){
        Clientes novoCliente = clientesService.createCliente(clientesDTO);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> getAllClients(){
        return new ResponseEntity<>(clientesService.getAllClients(), HttpStatus.OK);
    }
}
