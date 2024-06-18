package lucas.clubedolivro.controller;

import jakarta.validation.Valid;
import lucas.clubedolivro.infra.security.TokenService;
import lucas.clubedolivro.model.user.User;
import lucas.clubedolivro.model.user.UserRegisterDTO;
import lucas.clubedolivro.model.user.UserRequestDTO;
import lucas.clubedolivro.model.user.UserResponseDTO;
import lucas.clubedolivro.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;
    private UserService userService;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserRequestDTO userRequestDTO){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userRequestDTO.login(), userRequestDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = this.tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new UserResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRegisterDTO userRegisterDTO){
        if(this.userService.loadUserByUsername(userRegisterDTO.username()) != null) return ResponseEntity.badRequest().build();

        String encriptedPassword = new BCryptPasswordEncoder().encode(userRegisterDTO.password());
        User newUser = new User(userRegisterDTO.username(), encriptedPassword, userRegisterDTO.role());

        this.userService.createUser(newUser);

        return ResponseEntity.ok().build();
    }
}
