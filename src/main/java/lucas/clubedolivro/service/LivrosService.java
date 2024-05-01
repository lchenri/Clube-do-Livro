package lucas.clubedolivro.service;

import lucas.clubedolivro.model.Livros;
import lucas.clubedolivro.model.dtos.LivrosDTO;
import lucas.clubedolivro.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
