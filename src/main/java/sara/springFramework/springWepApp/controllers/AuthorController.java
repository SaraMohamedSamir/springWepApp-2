package sara.springFramework.springWepApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sara.springFramework.springWepApp.repository.AuthorRepository;

@Controller
public class AuthorController {

  private AuthorRepository authorRepository;

  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  @RequestMapping("/authors")
  public String getAuthors(Model model){
    model.addAttribute("authors", authorRepository.findAll());
    return "authors";
  }

}
