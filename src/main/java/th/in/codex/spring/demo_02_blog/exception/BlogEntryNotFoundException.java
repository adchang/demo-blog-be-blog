package th.in.codex.spring.demo_02_blog.exception;

public class BlogEntryNotFoundException extends RuntimeException {

  public BlogEntryNotFoundException(Long id) {
    super("BlogEntry " + id + " does not exist");
  }
}
