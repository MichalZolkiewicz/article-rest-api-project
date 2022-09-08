package com.example.articlerestapi.controller;

import com.example.articlerestapi.domain.ArticleDto;
import com.example.articlerestapi.service.ArticleServiceManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleServiceManager articleServiceManager;

    @GetMapping(value = "getArticles")
    public List<ArticleDto> getAllArticles() {
        return articleServiceManager.getAllArticles();
    }

    @GetMapping(value = "getCopy")
    public ArticleDto getArticle(@RequestParam Long articleId) {
        return articleServiceManager.getArticleDto(articleId);
    }

    @PostMapping(value = "addArticle")
    public Long addArticle(@RequestBody ArticleDto articleDto) {
        return articleServiceManager.addArticle(articleDto);
    }

    @PutMapping(value = "updateArticle")
    public Long updateArticle(@RequestParam Long articleId, @RequestParam String articleTitle, @RequestParam String articleContent){
        return articleServiceManager.updateArticle(articleId, articleTitle, articleContent);
    }

    @DeleteMapping(value = "deleteArticle")
    public void deleteArticle(@RequestParam Long articleId) {
        articleServiceManager.deleteArticle(articleId);
    }

    @GetMapping(value = "searchArticleKeyword")
    public List<ArticleDto> searchArticleKeyword(@RequestParam String keyword) {
        return articleServiceManager.searchArticleKeyword(keyword);
    }
}
