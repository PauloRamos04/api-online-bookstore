package online.bookstore.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import online.bookstore.api.domain.publisher.DadosCadastroPublisher;
import online.bookstore.api.domain.publisher.Publisher;
import online.bookstore.api.domain.publisher.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autores")
@SecurityRequirement(name = "bearer-key")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroPublisher dados){
        publisherRepository.save(new Publisher(dados));
    }
}
