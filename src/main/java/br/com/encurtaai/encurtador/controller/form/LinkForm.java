package br.com.encurtaai.encurtador.controller.form;

import br.com.encurtaai.encurtador.config.security.TokenService;
import br.com.encurtaai.encurtador.model.Link;
import br.com.encurtaai.encurtador.model.User;
import br.com.encurtaai.encurtador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class LinkForm {

    private String long_url;
    private String link;
    private String user;

    @Autowired
    private TokenService tokenService;

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Link convert(UserRepository repository) {
        Long userId =tokenService.getUserId(user);
        if(userId == null){
            return new Link(long_url, link, null);
        }
        User usuario = repository.findById(userId).get();
        return new Link(long_url, link, usuario);
    }
}
