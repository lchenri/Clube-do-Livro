package lucas.clubedolivro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lucas.clubedolivro.model.dtos.LivrosDTO;

@Entity(name = "Livros")
@Table(name = "Livros")
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeLivro;
    private String autor;
    private String editora;
    private String genero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientes_id")
    @JsonBackReference
    private Clientes clientes;

    public Livros(LivrosDTO livrosDTO) {
        this.nomeLivro = livrosDTO.nomeLivro();
        this.autor = livrosDTO.autor();
        this.editora = livrosDTO.editora();
        this.genero = livrosDTO.genero();
    }

}
