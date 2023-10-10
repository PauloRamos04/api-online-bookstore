package online.bookstore.api.domain.publisher;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPublisher(

        @NotBlank
        String nome,

        @NotBlank
        String descricao

) {
}
