package com.dev.jbs.ecommerce.service;

import com.dev.jbs.ecommerce.config.JwtUtil;
import com.dev.jbs.ecommerce.dto.response.AuthResponse;
import com.dev.jbs.ecommerce.dto.response.BasicResponse;
import com.dev.jbs.ecommerce.model.Usuario;
import com.dev.jbs.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public BasicResponse login(String username, String password) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);

        if(!usuario.isPresent()) return AuthResponse.usuarioNoEncontrado();
        if (!passwordEncoder.matches(password, usuario.get().getPassword())) return AuthResponse.passwordIncorrecto();

        return new BasicResponse()
                .builder()
                .status(200)
                .data(jwtUtil.generateToken(usuario.get().getUsername()))
                .message("Acceso Exitoso")
                .build();

    }

    @Override
    public BasicResponse register(Usuario usuario) {

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return new BasicResponse()
                .builder()
                .status(200)
                //.data(jwtUtil.generateToken(usuario.getUsername()))
                .message("Usuario generado con éxito")
                .build();
    }
}
