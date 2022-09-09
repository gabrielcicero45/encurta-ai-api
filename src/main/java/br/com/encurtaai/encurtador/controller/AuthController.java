package br.com.encurtaai.encurtador.controller;

import br.com.encurtaai.encurtador.config.security.TokenService;
import br.com.encurtaai.encurtador.controller.dto.TokenDto;
import br.com.encurtaai.encurtador.controller.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<TokenDto> signin(@RequestBody  LoginForm form){
        UsernamePasswordAuthenticationToken loginData = form.convert();
        try{
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            System.out.println(token);
            return ResponseEntity.ok(new TokenDto(token,"Bearer"));
        }
        catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }
}
