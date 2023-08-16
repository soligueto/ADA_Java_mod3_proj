package tech.ada.pokeada.dto.parser;

import org.apache.catalina.User;
import tech.ada.pokeada.dto.NovoUsuarioDTO;
import tech.ada.pokeada.dto.UsuarioDTO;
import tech.ada.pokeada.model.Usuario;

public class UsuarioDTOParser {

    public static UsuarioDTO toUsuarioDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setCpf(usuario.getCpf());
        dto.setEmail(usuario.getEmail());
        dto.setNome(usuario.getNome());
        dto.setId(usuario.getId());
        return dto;
    }

    public static NovoUsuarioDTO toNovoUsuarioDTO(Usuario user) {
        NovoUsuarioDTO dto = new NovoUsuarioDTO();
        dto.setCpf(user.getCpf());
        dto.setPass(user.getPassword());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static Usuario toUsuarioEntity(NovoUsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setCpf(dto.getCpf());
        entity.setPassword(dto.getPass());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
