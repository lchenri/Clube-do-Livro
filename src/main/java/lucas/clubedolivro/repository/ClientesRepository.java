package lucas.clubedolivro.repository;

import lucas.clubedolivro.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
