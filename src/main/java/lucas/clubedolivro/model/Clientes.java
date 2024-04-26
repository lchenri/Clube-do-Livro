package lucas.clubedolivro.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "Clientes")
@Table(name = "Clientes")
@Getter
@Setter
public class Clientes {

    @Id
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<Livros> livrosAdquiridos;


}
