package th.in.codex.spring.demo_02_blog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogAppController {
  
  @RequestMapping("/")
  public String index() {
    return "HelloWorld! I am a Blog App";
  }
}
