package br.com.encurtaai.encurtador.controller;

import br.com.encurtaai.encurtador.controller.form.LinkForm;
import br.com.encurtaai.encurtador.model.Link;
import br.com.encurtaai.encurtador.repository.LinkRepository;
import br.com.encurtaai.encurtador.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/links")
public class LinksController {
    @Autowired
    private LinkRepository linkRepository;
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
   @GetMapping
   public List<Link> list(){
       List<Link> list = linkRepository.findAll();
       if(!list.isEmpty()){
           return list;
       }
       return new ArrayList<>();

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void register(@ModelAttribute LinkForm form){
        Link link = form.convert(userRepository);
        linkRepository.save(link);
    }
}
