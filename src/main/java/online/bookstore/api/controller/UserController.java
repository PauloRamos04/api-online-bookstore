package online.bookstore.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import online.bookstore.api.domain.user.DadosCadastroUser;
import online.bookstore.api.domain.user.User;
import online.bookstore.api.domain.user.UserRepository;
import online.bookstore.api.domain.user.DadosAtualizaCadastroUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void cadastrarUser(@RequestBody @Valid DadosCadastroUser dados){
    userRepository.save(new User(dados));
    }
       
    @GetMapping()
    public List<User> listarUser(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizarUsuario(@RequestBody @Valid DadosAtualizaCadastroUser dados, @PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        user.atualizaUser(dados);
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void excluirUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }




}
