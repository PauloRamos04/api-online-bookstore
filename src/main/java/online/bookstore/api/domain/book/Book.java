package online.bookstore.api.domain.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import online.bookstore.api.domain.author.Author;
import online.bookstore.api.domain.publisher.Publisher;

@Table(name = "livros")
@Entity(name = "Book")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer anoPublicacao;

    @ManyToOne
    @JoinColumn(name = "autor_id") // Nome da coluna que representa o autor
    private Author autor;

    @ManyToOne
    @JoinColumn(name = "editora_id") // Nome da coluna que representa a editora
    private Publisher editora;

    @Column(name = "capa", columnDefinition = "BLOB")
    private byte[] capa;

    private String status;
    private Integer price;
//    private Integer stock;
    public Book(DadosCadastroBook dados, Author autor, Publisher editora, byte[] capa) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.anoPublicacao = dados.anoPublicacao();
        this.price = dados.price();
        this.autor = autor;
        this.editora = editora;
        this.capa = capa;
    }

}
