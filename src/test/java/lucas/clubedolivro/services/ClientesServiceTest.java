package lucas.clubedolivro.services;

import lucas.clubedolivro.model.clientes.Clientes;
import lucas.clubedolivro.model.clientes.ClientesDTO;
import lucas.clubedolivro.model.livros.Livros;
import lucas.clubedolivro.model.livros.LivrosDTO;
import lucas.clubedolivro.repository.ClientesRepository;
import lucas.clubedolivro.service.ClientesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientesServiceTest {
    @Mock
    private ClientesRepository clientesRepository;

    @InjectMocks
    private ClientesService clientesService;

    private Clientes cliente;
    private ClientesDTO clienteDTO;
    private Livros livro;
    private LivrosDTO livrosDTO;

    @BeforeEach
    void setUp(){
        String nome = "João";
        String endereco = "Rua dos Anjos, 280, São Paulo-SP";
        String telefone = "11988775544";
        clienteDTO = new ClientesDTO(nome, endereco, telefone);
        cliente = new Clientes(clienteDTO);
        cliente.setLivrosAdquiridos(new ArrayList<>());

        String nomeLivro = "Memórias Póstumas de Brás Cubas";
        String autor = "Machado de Assis";
        String editora = "Novo Livro";
        String genero = "Romance";
        livrosDTO = new LivrosDTO(nomeLivro, autor, editora, genero);
        livro = new Livros(livrosDTO);

        cliente.addLivrosAdquiridos(livro);
        livro.setClientes(cliente);
    }

    @Test
    void testCreateCliente(){
        when(clientesRepository.save(any(Clientes.class))).thenReturn(cliente);
        Clientes createdCliente = clientesService.createCliente(clienteDTO);

        assertNotNull(createdCliente);
        assertEquals("João", createdCliente.getNome());
        verify(clientesRepository, times(1)).save(any(Clientes.class));
    }

    @Test
    void testGetAllClientes(){
        when(clientesRepository.findAll()).thenReturn(Arrays.asList(cliente));
        List<Clientes> allClientes = clientesService.getAllClients();

        assertNotNull(allClientes);
        assertEquals(1, allClientes.size());
        verify(clientesRepository, times(1)).findAll();
    }

    @Test
    void testGetThisCliente(){
        when(clientesRepository.findByNome("João")).thenReturn(Optional.of(cliente));
        Optional<Clientes> foundCliente = clientesService.getThisCliente("João");

        assertTrue(foundCliente.isPresent());
        assertEquals("João", foundCliente.get().getNome());
        verify(clientesRepository, times(1)).findByNome("João");
    }

    @Test
    void testBookRegister(){
        when(clientesRepository.save(any(Clientes.class))).thenReturn(cliente);
        ResponseEntity<String> response = clientesService.bookRegister(cliente,livro);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Cliente João comprou o livro Memórias Póstumas de Brás Cubas", response.getBody());
        verify(clientesRepository, times(1)).save(any(Clientes.class));
    }

}
