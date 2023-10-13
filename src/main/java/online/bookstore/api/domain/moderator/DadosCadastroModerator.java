package online.bookstore.api.domain.moderator;

import jakarta.validation.constraints.NotNull;

public record DadosCadastroModerator(

        @NotNull
        Long livroId,

        @NotNull
        Long userId
) {

}
