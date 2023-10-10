package online.bookstore.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import online.bookstore.api.domain.administrador.Admin;
import online.bookstore.api.domain.administrador.AdminRepository;
import online.bookstore.api.domain.administrador.DadosAtualizaCadastroAdmin;
import online.bookstore.api.domain.administrador.DadosCadastroAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroAdmin dados){adminRepository.save(new Admin(dados));}
    @GetMapping()
    public List<Admin> listarAdmin(){
        return adminRepository.findAll();
    }

    @PutMapping("/{id}")
    @Transactional
    public void atualizaAdmin(@RequestBody @Valid DadosAtualizaCadastroAdmin dados, @PathVariable Long id) {
        // Verifica se o usuário existe antes de tentar atualizá-lo
        Admin admin = adminRepository.findById(id).orElseThrow();

        // Atualiza os dados do usuário
        admin.atualizaAdmin(dados);

        // Salva as alterações no banco de dados
        adminRepository.save(admin);
    }

    @DeleteMapping("/{id}")
    public void excluirUser(@PathVariable Long id){
        adminRepository.deleteById(id);
    }
}
