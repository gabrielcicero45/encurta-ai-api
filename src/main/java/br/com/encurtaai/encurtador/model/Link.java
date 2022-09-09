package br.com.encurtaai.encurtador.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String long_url;
    @Column
    private String link;
    @ManyToOne
    private User user;

    public Link() {
    }

    public Link(String long_url, String link, User user) {
        this.long_url = long_url;
        this.link = link;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
