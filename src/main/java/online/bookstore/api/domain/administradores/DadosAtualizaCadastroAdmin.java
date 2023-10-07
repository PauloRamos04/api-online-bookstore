package online.bookstore.api.domain.administradores;

public record DadosAtualizaCadastroAdmin(
    Long id,
    String nome,
    String email,
    String senha) {
}
