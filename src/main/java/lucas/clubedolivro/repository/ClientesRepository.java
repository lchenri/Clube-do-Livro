package lucas.clubedolivro.repository;

import lucas.clubedolivro.model.Clientes;
import lucas.clubedolivro.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
