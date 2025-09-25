package com.example.inventory.controller;

import com.example.inventory.dto.AuthRequest;
import com.example.inventory.dto.AuthResponse;
import com.example.inventory.dto.RegisterRequest;
import com.example.inventory.model.Usuario;
import com.example.inventory.repository.UsuarioRepository;
import com.example.inventory.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (usuarioRepository.findByUsEmail(req.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email ya registrado");
        }
        Usuario u = new Usuario();
        u.setUsNombre(req.getNombre());
        u.setUsApellido(req.getApellido());
        u.setUsEmail(req.getEmail());
        u.setUsTelefono(req.getTelefono());
        u.setUsRol(req.getRol() == null ? "ROLE_USER" : req.getRol());
        u.setUsContrasenaHash(passwordEncoder.encode(req.getPassword()));
        u.setUsFechaCreacion(LocalDate.now());
        usuarioRepository.save(u);
        return ResponseEntity.ok("Usuario creado");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
            String token = jwtUtil.generateToken(req.getEmail());
            return ResponseEntity.ok(new AuthResponse(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
