package online.bookstore.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import online.bookstore.api.domain.publisher.DadosCadastroPublisher;
import online.bookstore.api.domain.publisher.Publisher;
import online.bookstore.api.domain.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
@SecurityRequirement(name = "bearer-key")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;


    @GetMapping()
    public List<Publisher> listarPublisher(){return publisherRepository.findAll();}

    @DeleteMapping()
    public void excluirPublisher(@PathVariable Long id){publisherRepository.deleteById(id);}
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPublisher dados){
        publisherRepository.save(new Publisher(dados));
    }
}
