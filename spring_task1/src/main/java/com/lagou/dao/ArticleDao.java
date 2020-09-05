package com.lagou.dao;

import com.lagou.domain.Article;

import java.util.List;

public interface ArticleDao {

    public List<Article> findAll();

    public Article findById(Integer id);

    public void save(Article article);

    public void update(Article article);

    public void delete(Integer id);
}
