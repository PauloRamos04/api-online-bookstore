package online.bookstore.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import online.bookstore.api.domain.book.Book;
import online.bookstore.api.domain.book.BookRepository;
import online.bookstore.api.domain.moderator.DadosCadastroModerator;
import online.bookstore.api.domain.moderator.Moderator;
import online.bookstore.api.domain.moderator.ModeratorRepository;
import online.bookstore.api.domain.user.User;
import online.bookstore.api.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moderacao")
@SecurityRequirement(name = "bearer-key")
public class ModeratorController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModeratorRepository moderatorRepository;

    @PostMapping()
    public void cadastrar(@RequestBody @Valid DadosCadastroModerator dados){
        Book book = bookRepository.findById(dados.livroId())
                .orElseThrow(() -> new EntityNotFoundException("Livro não encontrado"));
        User user = userRepository.findById(dados.userId())
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
        Moderator moderator = new Moderator(dados, book, user);
        moderatorRepository.save(moderator);

    }
}
