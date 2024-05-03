package lucas.clubedolivro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lucas.clubedolivro.model.dtos.ClientesDTO;

import java.util.List;

@Entity(name = "Clientes")
@Table(name = "Clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Livros> livrosAdquiridos;

    public Clientes(ClientesDTO clientesDTO){
        this.nome = clientesDTO.nome();
        this.endereco = clientesDTO.endereco();
        this.telefone = clientesDTO.telefone();
    }

    public void addLivrosAdquiridos(Livros livro) {
        this.livrosAdquiridos.add(livro);
        livro.setClientes(this);
    }
}
