package th.in.codex.demo.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import th.in.codex.demo.blog.model.BlogEntry;

public interface BlogEntryDao extends JpaRepository<BlogEntry, Long>{

}
