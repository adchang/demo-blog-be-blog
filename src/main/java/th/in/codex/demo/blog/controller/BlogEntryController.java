package th.in.codex.demo.blog.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.in.codex.demo.blog.dao.BlogEntryDao;
import th.in.codex.demo.blog.exception.BlogEntryNotFoundException;
import th.in.codex.demo.blog.model.BlogEntry;

@RestController
@RequestMapping(value = Uris.BLOG_ENTRY, produces = Uris.APP_JSON) 
public class BlogEntryController {
  // spring.io/guides/tutorials/rest
  
  private final BlogEntryDao dao;
  private final BlogEntryModelAssembler assembler;

  BlogEntryController(BlogEntryDao dao, BlogEntryModelAssembler assembler) {
    this.dao = dao;
    this.assembler = assembler;
  }

  @GetMapping()
  CollectionModel<EntityModel<BlogEntry>> all() {
    List<EntityModel<BlogEntry>> data = dao.findAll().stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());
    
    return CollectionModel.of(data, 
        linkTo(methodOn(BlogEntryController.class).all()).withSelfRel());
  }

  @PostMapping
  BlogEntry create(@RequestBody BlogEntry newBlogEntry) {
    // curl -X POST localhost:8080/blogEntries -H 'Content-type:application/json' -d '{"authorId": "1", "blogId": "2", "body": "I am some body", "title": "from post"}'
    return dao.save(newBlogEntry);
  }

  @GetMapping(Uris.PARAM_ID)
  EntityModel<BlogEntry> get(@PathVariable Long id) {

    BlogEntry blogEntry = dao.findById(id)
      .orElseThrow(() -> new BlogEntryNotFoundException(id));

    return assembler.toModel(blogEntry);
  }

  @PutMapping(Uris.PARAM_ID)
  BlogEntry update(@RequestBody BlogEntry newBlogEntry, @PathVariable Long id) {

    return dao.findById(id)
      .map(blogEntry -> {
        blogEntry.setBlogId(newBlogEntry.getBlogId());
        blogEntry.setAuthorId(newBlogEntry.getAuthorId());
        blogEntry.setTitle(newBlogEntry.getTitle());
        blogEntry.setBody(newBlogEntry.getBody());
        return dao.save(blogEntry);
      })
      .orElseGet(() -> {
        newBlogEntry.setId(id);
        return dao.save(newBlogEntry);
      });
  }
  
  @PutMapping(Uris.PARAM_ID + "/" + Uris.SUBMIT)
  BlogEntry submitForApproval(@PathVariable Long id) {
    
    return null;
  }
  
  @PutMapping(Uris.PARAM_ID + "/" + Uris.APPROVE)
  BlogEntry approve(@PathVariable Long id) {
    
    return null;
  }
}
