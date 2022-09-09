package com.example.articlerestapi.repositories;

import com.example.articlerestapi.domain.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ArticleRepository extends CrudRepository <Article, Long> {

    Article findById(long id);

    @Override
    List<Article> findAll();

    @Override
    Article save(Article article);

    void deleteById(Long id);

    @Override
    void deleteAll();
}
