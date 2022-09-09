package com.example.articlerestapi.service;

import com.example.articlerestapi.domain.Article;
import com.example.articlerestapi.domain.ArticleDto;
import com.example.articlerestapi.repositories.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArticleServiceManagerTest {

    @Autowired
    ArticleServiceManager articleServiceManager;

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void testGetAllArticles() {
        Article article1 = new Article();
        article1.setDateOfPublication(LocalDate.of(2010, 12, 8));

        Article article2 = new Article();
        article2.setDateOfPublication(LocalDate.of(2012, 8, 7));


        articleRepository.save(article1);
        articleRepository.save(article2);


        int index = articleServiceManager.getAllArticles().lastIndexOf(article2);

        assertEquals(-1, index);
        articleRepository.deleteById(article1.getId());
        articleRepository.deleteById(article2.getId());
    }

    @Test
    public void testAddArticle() {
        Article article = new Article();

        articleRepository.save(article);
        long articleId = article.getId();

        assertNotEquals(0, articleId);

        articleRepository.deleteById(articleId);
    }

    @Test
    public void deleteArticle() {
        Article article = new Article();

        articleRepository.save(article);
        long articleId = article.getId();

        articleRepository.deleteById(articleId);
        assertFalse(articleRepository.existsById(articleId));
    }

    @Test
    public void testUpdateArticle() {
        Article article = new Article();
        article.setArticleTitle("TEST");
        article.setArticleContent("treść testowa");

        articleRepository.save(article);

        Long updatedId = articleServiceManager.updateArticle(article.getId(), "TEST2", "treść testowa2");

        assertEquals(article.getId(), updatedId);

        articleRepository.deleteAll();
    }

    @Test
    public void testSearchArticleKeyword() {
        Article article = new Article();

        String title = "TEST";
        String content = "treść testowa";

        article.setArticleTitle(title);
        article.setArticleContent(content);

        Article article2 = new Article();

        String title2 = "DRUGA";
        String content2 = "treść testowa";
        article2.setArticleTitle(title2);
        article2.setArticleContent(content2);

        articleRepository.save(article);
        articleRepository.save(article2);

        Long articleId = article.getId();
        Long article2Id = article2.getId();

        List<ArticleDto> listOfArticlesWithKeyword = articleServiceManager.searchArticleKeyword(title);

        assertFalse(listOfArticlesWithKeyword.isEmpty());

        articleRepository.deleteById(articleId);
        articleRepository.deleteById(article2Id);
    }
}
