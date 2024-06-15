package lucas.clubedolivro.service;

import lucas.clubedolivro.model.livros.Livros;
import lucas.clubedolivro.model.livros.LivrosDTO;
import lucas.clubedolivro.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public Livros createLivro(LivrosDTO livrosDTO){
        Livros novoLivro = new Livros(livrosDTO);
        return livrosRepository.save(novoLivro);
    }

    public List<Livros> getAllLivros(){
        return livrosRepository.findAll();
    }

    public Optional<Livros> getThisLivro(String nomeLivro){
        Optional<Livros> livro = livrosRepository.findByNomeLivro(nomeLivro);
        return livro;
    }


}
