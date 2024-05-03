package lucas.clubedolivro.service;

import lucas.clubedolivro.model.Clientes;
import lucas.clubedolivro.model.Livros;
import lucas.clubedolivro.model.dtos.ClientesDTO;
import lucas.clubedolivro.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes createCliente(ClientesDTO clientesDTO){
        Clientes novoCliente = new Clientes(clientesDTO);
        return clientesRepository.save(novoCliente);
    }

    public List<Clientes> getAllClients(){
        return clientesRepository.findAll();
    }

    public Optional<Clientes> getThisCliente(String nome){
        Optional<Clientes> cliente = clientesRepository.findByNome(nome);
        return cliente;
    }

    public ResponseEntity<String> bookRegister(Clientes cliente, Livros livro){
        cliente.addLivrosAdquiridos(livro);
        clientesRepository.save(cliente);
        String registrado = "Cliente " + cliente.getNome() + " comprou o livro " + livro.getNomeLivro();
        return new ResponseEntity<>(registrado, HttpStatus.OK);
    }

}
