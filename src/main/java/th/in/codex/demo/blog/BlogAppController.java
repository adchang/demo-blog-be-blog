package th.in.codex.demo.blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogAppController {
  
  @RequestMapping("/")
  public String index() {
    return "HelloWorld! I am a Blog App";
  }
}
