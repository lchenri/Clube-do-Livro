package lucas.clubedolivro.controller;

import jakarta.validation.Valid;
import lucas.clubedolivro.model.user.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserRequestDTO userRequestDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userRequestDTO.login(), userRequestDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        //implement tokenservice
    }
}
