package br.com.encurtaai.encurtador.repository;

import br.com.encurtaai.encurtador.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link,Long> {

}
