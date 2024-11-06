package com.example.demo.Controller;

import com.example.demo.DTO.LoginDTO;
import com.example.demo.Enums.LoginEnum;
import com.example.demo.Model.Usuario;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.Service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UsuarioRepository ur;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping(value = "/logar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String authenticate(@RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var user = (Usuario) authenticate.getPrincipal();
        return tokenService.tokenGeneration(user);
    }

    @GetMapping("/teste")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastroUsuario(@RequestBody @Valid Usuario usuario) {
        usuario.setLoginEnum(LoginEnum.USER);
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok().body(ur.save(usuario));
    }
}