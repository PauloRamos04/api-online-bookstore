package online.bookstore.api.domain.user;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCadastroUser(
        Long id,
        String nome,
        String email,
        String senha) {
}
