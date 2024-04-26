package lucas.clubedolivro.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Livros")
@Table(name = "Livros")
@EqualsAndHashCode
@Getter
@Setter
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
    private Clientes clientes;


}
