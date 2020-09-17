package th.in.codex.spring.demo_02_blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import th.in.codex.spring.demo_02_blog.model.BlogEntry;

public interface BlogEntryDao extends JpaRepository<BlogEntry, Long>{

}
