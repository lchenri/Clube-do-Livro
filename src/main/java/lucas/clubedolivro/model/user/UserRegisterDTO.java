package lucas.clubedolivro.model.user;

import jakarta.validation.constraints.NotBlank;

public record UserRegisterDTO(
        @NotBlank
        String username,
        @NotBlank
        String password,
        @NotBlank
        UserRole role
) {
}
