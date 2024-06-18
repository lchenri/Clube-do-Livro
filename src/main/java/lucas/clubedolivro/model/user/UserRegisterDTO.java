package lucas.clubedolivro.model.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRegisterDTO(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotNull
        UserRole role
) {
}
