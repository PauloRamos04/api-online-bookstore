package online.bookstore.api.records.user;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizaCadastroUser(
        Long id,
        String nome,
        String email,
        String senha) {
}
