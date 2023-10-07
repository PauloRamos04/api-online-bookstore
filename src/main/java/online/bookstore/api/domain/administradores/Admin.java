package online.bookstore.api.domain.administradores;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name="administradores")
@Entity(name="Admin")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;



    public Admin(DadosCadastroAdmin dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void atualizaAdmin(@Valid DadosAtualizaCadastroAdmin dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
    }

}
