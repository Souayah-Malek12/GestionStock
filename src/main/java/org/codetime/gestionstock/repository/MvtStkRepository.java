package org.codetime.gestionstock.repository;

import java.math.BigDecimal;
import java.util.List;

import org.codetime.gestionstock.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {

  @Query("select sum(m.quantite) from MvtStk m where m.article.id = :idArticle")
  BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

  List<MvtStk> findAllByArticleId(Integer idArticle);

}
