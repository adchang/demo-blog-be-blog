package th.in.codex.demo.blog.dao;

import org.springframework.data.repository.CrudRepository;

import th.in.codex.demo.blog.model.BlogEntry;

public interface BlogEntryDao extends CrudRepository<BlogEntry, Long>{

}
