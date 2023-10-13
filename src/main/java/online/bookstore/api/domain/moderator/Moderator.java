package online.bookstore.api.domain.moderator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online.bookstore.api.domain.book.Book;
import online.bookstore.api.domain.user.User;

import java.util.Date;

@Table(name="moderacao")
@Entity(name="Moderadores")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Moderator{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date data;
    private String status;

    @PrePersist
    public void prePersist() {
        this.data = new Date(); // Define a data atual antes de persistir
        this.status = "Aguardando aprovação"; // Define o status padrão
    }


    public Moderator(DadosCadastroModerator dados, Book book, User user) {
        this.book = book;
        this.user = user;
    }
}
