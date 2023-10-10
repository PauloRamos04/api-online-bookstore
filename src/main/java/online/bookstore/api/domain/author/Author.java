package online.bookstore.api.domain.author;

import jakarta.persistence.*;
import lombok.*;

@Table(name="autores")
@Entity(name="Author")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String biografia;
}
