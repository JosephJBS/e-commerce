package com.dev.jbs.ecommerce.controller;

import com.dev.jbs.ecommerce.config.JwtUtil;
import com.dev.jbs.ecommerce.dto.response.BasicResponse;
import com.dev.jbs.ecommerce.model.Usuario;
import com.dev.jbs.ecommerce.repository.UsuarioRepository;
import com.dev.jbs.ecommerce.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<BasicResponse> register(@RequestBody Usuario usuario) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(authService.register(usuario));
            //authService.register(usuario);
        }catch (Exception e) {
            log.error("Error al registrarse: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Usuario no registrado")
                            .data(null)
                            .build());
        }

    }

    @PostMapping("/login")
    public ResponseEntity<BasicResponse> login(@RequestBody Map<String, String> request) {

        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(authService.login(request.get("username"),request.get("password")));
            //authService.register(usuario);
        }catch (Exception e) {
            log.error("Error al registrarse: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(BasicResponse.builder()
                            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                            .message("Usuario no registrado")
                            .data(null)
                            .build());
        }
    }
}