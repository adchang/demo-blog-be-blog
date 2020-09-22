package th.in.codex.demo.blog.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlogEntry {

  private @Id @GeneratedValue Long id;
  private Long blogId;
  private String authorId;
  private String title;
  private String body;
  private @Enumerated(EnumType.STRING) BlogEntryStatus status;
  // Labels
  
  public BlogEntry() {}
  
  public BlogEntry(Long blogId, String authorId, String title, String body) {
    this(blogId, authorId, title, body, BlogEntryStatus.IN_PROGRESS);
  }
  
  public BlogEntry(Long blogId, String authorId, String title, String body, BlogEntryStatus status) {
    this.blogId = blogId;
    this.authorId = authorId;
    this.title = title;
    this.body = body;
    this.status = status;
  }

  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public Long getBlogId() {
    return blogId;
  }
  
  public void setBlogId(Long blogId) {
    this.blogId = blogId;
  }

  public String getAuthorId() {
    return authorId;
  }
  
  public void setAuthorId(String authorId) {
    this.authorId = authorId;
  }
  
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getBody() {
    return body;
  }
  
  public void setBody(String body) {
    this.body = body;
  }
  
  public BlogEntryStatus getStatus() {
    return status;
  }

  public void setStatus(BlogEntryStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "BlogEntry {id = " + id + ", blogId = " + blogId + ", authorId = " + authorId + 
        ", status = " + status +
        ", title = '" + title + "', body = '" + body + "'}";
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, blogId, authorId, title, body, status);
  }

  @Override
  public boolean equals(Object obj) {
    return obj.toString().equals(toString());
  }
}

