package org.codetime.gestionstock.repository;

import org.codetime.gestionstock.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends  JpaRepository<Article, Long> {
    Optional<Article> findArticleByCodeArticle(String codeArticle);
    List<Article> getAllByCategoryId(Long idCategory);
}
