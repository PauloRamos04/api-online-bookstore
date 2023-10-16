package online.bookstore.api.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;

public record DadosCadastroUser(

        String id,
        @NotBlank
        String nome,
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Pattern(regexp = "[A-Za-z0-9]{8,16}")
        String senha,
        UserRole role
){ public DadosCadastroUser(String id, String nome, String email, String senha) {
                this(id, nome, email, senha, UserRole.USER);
        }
}


