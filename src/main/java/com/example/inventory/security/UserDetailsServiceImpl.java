package com.example.inventory.security;

import com.example.inventory.model.Usuario;
import com.example.inventory.repository.UsuarioRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByUsEmail(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new User(u.getUsEmail(), u.getUsContrasenaHash(), Collections.singletonList(new SimpleGrantedAuthority(u.getUsRol())));
    }
}
