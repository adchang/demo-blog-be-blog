package th.in.codex.spring.demo_02_blog.controller;

public class Uris {

  public static final String BLOG_ENTRY = "/blogEntries";
  
  public static final String SUBMIT = "submit";
  public static final String APPROVE = "approve";
  
  public static final String PARAM_ID = "/{id}";
  
  public static final String APP_JSON = "application/hal+json";
  
  private Uris() {
    // Prevent instantiation
  }
}
