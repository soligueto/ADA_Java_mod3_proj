package tech.ada.pokeada.service;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.ada.pokeada.dto.UserDetailsInfo;
import tech.ada.pokeada.model.Usuario;
import tech.ada.pokeada.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsuarioRepository repository;

    public UserDetailServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUser = repository.findByEmail(username);
        return new UserDetailsInfo(optionalUser.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado")));
    }
}
