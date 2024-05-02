package lucas.clubedolivro.repository;

import lucas.clubedolivro.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LivrosRepository extends JpaRepository<Livros, Long> {
    Optional<Livros> findByNomeLivro(String nomeLivro);
}
