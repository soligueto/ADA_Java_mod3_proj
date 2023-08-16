package tech.ada.pokeada.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tech.ada.pokeada.dto.NovoUsuarioDTO;
import tech.ada.pokeada.dto.UsuarioDTO;
import tech.ada.pokeada.dto.parser.UsuarioDTOParser;
import tech.ada.pokeada.exceptions.UsuarioNaoEncontradoException;
import tech.ada.pokeada.model.Usuario;
import tech.ada.pokeada.repository.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    public UsuarioDTO salvar(NovoUsuarioDTO user) {
        user.setPass(encoder.encode(user.getPass()));
        return UsuarioDTOParser
                .toUsuarioDTO(usuarioRepository.save(UsuarioDTOParser.toUsuarioEntity(user)));
    }

    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTOParser::toUsuarioDTO)
                .collect(Collectors.toList());
    }

    public UsuarioDTO findById(Long id) {
        Usuario user = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário de ID " + id + " não encontrado."));

        return UsuarioDTOParser.toUsuarioDTO(user);
    }

    public UsuarioDTO atualizar(NovoUsuarioDTO usuario, Long id) {
        findById(id);
        Usuario usuarioEntity = UsuarioDTOParser.toUsuarioEntity(usuario);
        usuarioEntity.setId(id);

        return UsuarioDTOParser
                .toUsuarioDTO(usuarioRepository.save(usuarioEntity));

    }

    public void deletar(Long id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }
}
