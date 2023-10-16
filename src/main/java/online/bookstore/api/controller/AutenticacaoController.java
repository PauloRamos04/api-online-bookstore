package online.bookstore.api.controller;

import jakarta.validation.Valid;
import online.bookstore.api.domain.administrador.AdminRepository;
import online.bookstore.api.domain.user.*;
import online.bookstore.api.infra.security.TokenService;
import online.bookstore.api.infra.security.DadosTokenJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;





    @PostMapping("/login")
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados){
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
            var authentication = this.manager.authenticate(authenticationToken);
            var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid DadosCadastroUser data) {
        if (this.userRepository.findByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().build();
        }

//        String encryptedPass = new BCryptPasswordEncoder().encode(data.senha());
//        UserRole userRole = data.role();

        User newUser = new User(data);

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }




}
