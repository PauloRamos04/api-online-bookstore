package online.bookstore.api.domain.administradores;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAdmin(

        @NotBlank
        String id,
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,

        @NotBlank
        @Pattern(regexp = "[A-Za-z0-9]{8,16}")
        String senha
        ){
}
