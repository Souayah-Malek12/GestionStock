package org.codetime.gestionstock.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.codetime.gestionstock.dto.ArticleDto;
import org.codetime.gestionstock.exception.EntityNotFoundException;
import org.codetime.gestionstock.exception.ErrorCodes;
import org.codetime.gestionstock.exception.InvalidEntityException;
import org.codetime.gestionstock.model.Article;
import org.codetime.gestionstock.repository.ArticleRepository;
import org.codetime.gestionstock.services.ArticleService;
import org.codetime.gestionstock.validator.ArticleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



import java.util.stream.Stream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }

    @Override
    public void delete(Integer Id) {

    }

    @Override
    public ArticleDto findById(Integer id) {
        if( id==null){
            log.error("article id is not valid");
        }

        Optional<Article> article = articleRepository.findById(id.longValue());


        ArticleDto dto = ArticleDto.fromEntity(article.get());

        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()-> new EntityNotFoundException("article not found "+ id+"non trouvé"+
                ErrorCodes.ARTICLE_NOT_FOUND)
        );
    }


    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.error("Article Code is null");
        }

        return articleRepository.findArticleByCodeArticle(codeArticle)
                .map(ArticleDto::fromEntity)
                .orElseThrow(
                        ()->new EntityNotFoundException(
                                " \"Aucun article avec le CODE = \" + codeArticle ",
                                ErrorCodes.ARTICLE_NOT_FOUND
                        ));

    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll()
                .stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    public ArticleDto save(ArticleDto dto){
        List<String> errors = ArticleValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Article not valid {}", dto);
            throw new InvalidEntityException("l'article not valid ", ErrorCodes.ARTICLE_NOT_VALID, errors);
        }

        return ArticleDto.fromEntity(
                articleRepository.save(
                        ArticleDto.toEntity((dto))
                )
        );
    }
}