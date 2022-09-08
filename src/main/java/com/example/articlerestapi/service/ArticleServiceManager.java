package com.example.articlerestapi.service;

import com.example.articlerestapi.domain.Article;
import com.example.articlerestapi.domain.ArticleDto;
import com.example.articlerestapi.mapper.ArticleMapper;
import com.example.articlerestapi.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceManager {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return articleMapper.mapToArticleDtoList(articles);
    }

    /*public Article getArticle(final long articleId) {
        return articleRepository.findById(articleId);
    }*/

    public ArticleDto getArticleDto(final long articleId) {
        Article article = articleRepository.findById(articleId);
        return articleMapper.mapToArticleDto(article);
    }

    public Long addArticle(ArticleDto articleDto) {
        Article article = articleMapper.mapToArticle(articleDto);
        articleRepository.save(article);

        return article.getId();
    }

    public void deleteArticle(final long articleId) {
        articleRepository.deleteById(articleId);
    }

    public Long updateArticle(long articleId, ArticleDto articleDto) {
        Article article = articleRepository.findById(articleId);
        return articleId;
    }
 }
