package com.example.articlerestapi.mapper;

import com.example.articlerestapi.domain.Article;
import com.example.articlerestapi.domain.ArticleDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleMapper {

    public Article mapToArticle(final ArticleDto articleDto) {
        return new Article(articleDto.getUserId(),
                           articleDto.getDateOfPublication(),
                           articleDto.getMagazineName(),
                           articleDto.getTimestamp());
    }

    public ArticleDto mapToArticleDto(final Article article) {
        return new ArticleDto(article.getId(),
                              article.getDateOfPublication(),
                              article.getMagazineName(),
                              article.getTimestamp());
    }

    public List<ArticleDto> mapToArticleDtoList(final List<Article> articleList) {
        return articleList.stream()
                .map(this::mapToArticleDto)
                .collect(Collectors.toList());
    }
}
