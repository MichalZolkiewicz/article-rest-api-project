package com.example.articlerestapi.service;

import com.example.articlerestapi.domain.Article;
import com.example.articlerestapi.domain.ArticleDto;
import com.example.articlerestapi.mapper.ArticleMapper;
import com.example.articlerestapi.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Long updateArticle(long articleId, String articleTitle, String articleContent) {
        Article article = articleRepository.findById(articleId);
        article.setArticleTitle(articleTitle);
        article.setArticleContent(articleContent);

        Article newArticle = articleRepository.save(article);
        articleMapper.mapToArticleDto(newArticle);
        return newArticle.getId();
    }

    public List<ArticleDto> searchArticleKeyword(String keyword) {
        List<Article> articleList = articleRepository.findAll();

        List<Article> articlesListWithKeyword = new ArrayList<>();
        for(Article article : articleList) {
            if(article.getArticleTitle().contains(keyword) || article.getArticleContent().contains(keyword)) {
                articlesListWithKeyword.add(article);
            }
        }
        return articleMapper.mapToArticleDtoList(articlesListWithKeyword);
    }
 }
