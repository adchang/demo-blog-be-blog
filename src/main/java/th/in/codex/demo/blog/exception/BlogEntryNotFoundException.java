package th.in.codex.demo.blog.exception;

public class BlogEntryNotFoundException extends RuntimeException {

  public BlogEntryNotFoundException(Long id) {
    super("BlogEntry " + id + " does not exist");
  }
}
