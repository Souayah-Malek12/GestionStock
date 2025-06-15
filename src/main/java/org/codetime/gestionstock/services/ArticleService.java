package org.codetime.gestionstock.services;

import org.codetime.gestionstock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

     ArticleDto save(ArticleDto dto);
     ArticleDto findById(Integer Id);
     ArticleDto findByCodeArticle(String codeArticle);
     List<ArticleDto> findAll();
     void delete(Integer Id);

}
