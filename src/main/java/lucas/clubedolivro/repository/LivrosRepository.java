package lucas.clubedolivro.repository;

import lucas.clubedolivro.model.clientes.Clientes;
import lucas.clubedolivro.model.livros.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {
    Optional<Livros> findByNomeLivro(String nomeLivro);
    Optional<Livros> findByClientes_Id (Long clienteId);
}
