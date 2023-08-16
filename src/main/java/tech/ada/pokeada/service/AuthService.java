package tech.ada.pokeada.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import tech.ada.pokeada.config.JwtService;
import tech.ada.pokeada.dto.AuthRequestDTO;
import tech.ada.pokeada.dto.AuthResponseDTO;
import tech.ada.pokeada.exceptions.UsuarioNaoEncontradoException;
import tech.ada.pokeada.model.Usuario;
import tech.ada.pokeada.repository.UsuarioRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;

    public AuthService(JwtService jwtService, UsuarioRepository usuarioRepository, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponseDTO authenticate(AuthRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        Usuario usuario = usuarioRepository.findByEmail(request.getUsername()).orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("nome", "Rodolfo");

        String token = jwtService.generateToken(usuario, extraClaims);
        return new AuthResponseDTO(token);
    }
}
