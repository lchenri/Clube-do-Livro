package lucas.clubedolivro.repository;

import lucas.clubedolivro.model.clientes.Clientes;
import lucas.clubedolivro.model.livros.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    Optional<Clientes> findByNome(String nome);
    Optional<Clientes> findClientesByLivrosAdquiridosContains(Livros livro);
}
