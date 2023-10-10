package online.bookstore.api.domain.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroBook(
        @NotBlank
        String titulo,

        @NotBlank
        String descricao,

        @NotNull
        Integer anoPublicacao,

        @NotNull
        Long autorId,

        @NotNull
        Long editoraId
) {
}
