package org.codetime.gestionstock.controller;

import org.codetime.gestionstock.controller.Api.ArticleApi;
import org.codetime.gestionstock.dto.ArticleDto;
import org.codetime.gestionstock.services.ArticleService;
import org.codetime.gestionstock.services.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService ){
        this.articleService = articleService;
    }

    @Override
    public void delete(Integer Id) {
        articleService.delete(Id);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public ArticleDto findById(Integer Id) {
        return articleService.findById(Id);
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }
}
