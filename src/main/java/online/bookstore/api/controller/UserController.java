package online.bookstore.api.controller;

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
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroUser dados){
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
        // Verifica se o usuário existe antes de tentar atualizá-lo
        User user = userRepository.findById(id).orElseThrow();

        // Atualiza os dados do usuário
        user.atualizaUser(dados);

        // Salva as alterações no banco de dados
        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void excluirUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> excluirUser(@PathVariable Long id) {
//        try {
//            // Verifique se o usuário está vinculado à moderação
//            if (userRepository.existsById(id)) {
//                // Se o usuário existir, verifique se ele está vinculado à moderação
//                boolean isUsuarioVinculadoAModeracao = moderacaoRepository.existsByUsuarioId(id);
//
//                if (isUsuarioVinculadoAModeracao) {
//                    // Não permita a exclusão, pois o usuário está vinculado à moderação
//                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                            .body("Este usuário está vinculado à moderação e não pode ser excluído.");
//                } else {
//                    // Se o usuário não estiver vinculado à moderação, exclua-o
//                    userRepository.deleteById(id);
//                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//                }
//            } else {
//                // O usuário não existe
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Usuário não encontrado com o ID: " + id);
//            }
//        } catch (Exception e) {
//            // Lide com exceções aqui e retorne uma resposta apropriada, por exemplo:
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Ocorreu um erro ao excluir o usuário.");
//        }
//    }




}
