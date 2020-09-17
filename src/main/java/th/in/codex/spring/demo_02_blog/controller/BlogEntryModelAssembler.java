package th.in.codex.spring.demo_02_blog.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import th.in.codex.spring.demo_02_blog.model.BlogEntry;
import th.in.codex.spring.demo_02_blog.model.BlogEntryStatus;

@Component
public class BlogEntryModelAssembler implements RepresentationModelAssembler<BlogEntry, EntityModel<BlogEntry>> {
  
  @Override
  public EntityModel<BlogEntry> toModel(BlogEntry blogEntry) {

    EntityModel<BlogEntry> model = EntityModel.of(blogEntry,
        linkTo(methodOn(BlogEntryController.class).get(blogEntry.getId())).withSelfRel(),
        linkTo(methodOn(BlogEntryController.class).all()).withRel(Uris.BLOG_ENTRY));
    
    if (blogEntry.getStatus() == BlogEntryStatus.IN_PROGRESS) {
      model.add(linkTo(methodOn(BlogEntryController.class)
          .submitForApproval(blogEntry.getId())).withRel(Uris.SUBMIT));
    } else if (blogEntry.getStatus() == BlogEntryStatus.PENDING_APPROVAL) {
      model.add(linkTo(methodOn(BlogEntryController.class)
          .approve(blogEntry.getId())).withRel(Uris.APPROVE));
    }
    
    return model;
  }
}
