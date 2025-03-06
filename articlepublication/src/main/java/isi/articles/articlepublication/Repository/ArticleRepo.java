package isi.articles.articlepublication.Repository;

import isi.articles.articlepublication.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long> {
    List<Article> findArticleByDomaineContaining(Long id);
    List<Article> findArticleByMotclesContaining(String keyword);
}
