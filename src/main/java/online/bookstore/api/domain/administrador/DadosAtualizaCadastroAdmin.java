package online.bookstore.api.domain.administrador;

public record DadosAtualizaCadastroAdmin(
    Long id,
    String nome,
    String email,
    String senha) {
}
