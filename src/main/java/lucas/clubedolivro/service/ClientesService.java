package lucas.clubedolivro.service;

import lucas.clubedolivro.model.Clientes;
import lucas.clubedolivro.model.dtos.ClientesDTO;
import lucas.clubedolivro.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
