package online.bookstore.api.domain.publisher;

import jakarta.persistence.*;
import lombok.*;

@Table(name="editoras")
@Entity(name="Publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    public Publisher(DadosCadastroPublisher dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }


}
