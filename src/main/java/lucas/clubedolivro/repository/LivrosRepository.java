package lucas.clubedolivro.repository;

import lucas.clubedolivro.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {
}
