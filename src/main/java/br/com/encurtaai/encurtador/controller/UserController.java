package br.com.encurtaai.encurtador.controller;

import br.com.encurtaai.encurtador.controller.form.LinkForm;
import br.com.encurtaai.encurtador.controller.form.UserForm;
import br.com.encurtaai.encurtador.model.Link;
import br.com.encurtaai.encurtador.model.User;
import br.com.encurtaai.encurtador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/users/register")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity register(@RequestBody UserForm form){
        User user= form.convert();
        try{
            userRepository.save(user);
            return ResponseEntity.ok().build();
        }
        catch (AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }

    }
}
