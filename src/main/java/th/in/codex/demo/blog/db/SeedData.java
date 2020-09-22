package th.in.codex.demo.blog.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import th.in.codex.demo.blog.dao.BlogEntryDao;
import th.in.codex.demo.blog.model.BlogEntry;
import th.in.codex.demo.blog.model.BlogEntryStatus;

@Configuration
public class SeedData {

  private static final Logger log = LoggerFactory.getLogger(SeedData.class);
/*
  @Bean
  // Note: All CommandLineRunner beans are executed upon application context load
  CommandLineRunner seedInitialData(BlogEntryDao blogEntryDao) {

    return args -> {
      log.info("Preloading " + blogEntryDao.save(new BlogEntry(1L, "5f63735a76bda3058d8298b5", "First Blog",
          "Lorem Ipsum 1.1")));
      log.info("Preloading " + blogEntryDao.save(new BlogEntry(1L, "5f637181b1304803f6b994dd", "First Blog",
          "Lorem Ipsum 1.2")));
      log.info("Preloading " + blogEntryDao.save(new BlogEntry(1L, "5f63735a76bda3058d8298b5", "First Blog",
          "Lorem Ipsum 1.1 second")));
      log.info("Preloading " + blogEntryDao.save(new BlogEntry(2L, "BAD", "Second Blog",
          "Lorem Ipsum 2.3", BlogEntryStatus.PENDING_APPROVAL)));
    };
  }
*/
}
