package br.com.encurtaai.encurtador.controller.form;

import br.com.encurtaai.encurtador.model.User;
import br.com.encurtaai.encurtador.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserForm {
        private String name;
        private String email;
        private String  password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User convert() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        setPassword(passwordEncoder.encode(password));
        return new User(name,email,password);
    }
}
