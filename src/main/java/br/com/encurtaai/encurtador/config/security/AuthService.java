package br.com.encurtaai.encurtador.config.security;

import br.com.encurtaai.encurtador.model.User;
import br.com.encurtaai.encurtador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByEmail(username));
        if(user.isPresent()){
            return (UserDetails) user.get();
        }
        throw new UsernameNotFoundException("Crendenciais invalidas");
    }
}
