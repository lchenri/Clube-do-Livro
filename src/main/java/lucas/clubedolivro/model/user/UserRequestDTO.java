package lucas.clubedolivro.model.user;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
