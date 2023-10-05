package online.bookstore.api.controller;

import online.bookstore.api.models.user.DadosCadastroUser;
import online.bookstore.api.models.user.User;
import online.bookstore.api.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroUser dados){
        userRepository.save(new User(dados));
    }

}
