package tech.ada.pokeada.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.pokeada.dto.AuthRequestDTO;
import tech.ada.pokeada.dto.AuthResponseDTO;
import tech.ada.pokeada.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody @Valid AuthRequestDTO request) {
       return ResponseEntity.ok(authService.authenticate(request));
    }
}
