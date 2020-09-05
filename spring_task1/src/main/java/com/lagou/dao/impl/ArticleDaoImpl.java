package com.lagou.dao.impl;

import com.lagou.dao.ArticleDao;
import com.lagou.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Article> findAll() {

        List<Article> list = null;
        //编写sql
        String sql = "select * from t_article";
        // 执行sql
        list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Article>(Article.class));

        return list;
    }

    @Override
    public Article findById(Integer id) {

        Article query = null;
        // 编写sql
        String sql = "select * from t_article where id = ?";

        query = (Article) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Article>(Article.class),id);

        return query;
    }

    @Override
    public void save(Article article) {

        String sql = "insert into t_article values(null,?,?)";
        jdbcTemplate.update(sql,article.getContent(),article.getTitle());

    }

    @Override
    public void update(Article article) {

        String sql = "update t_article set content = ?,title = ? where id = ?";
        jdbcTemplate.update(sql,article.getContent(),article.getTitle(),article.getId());

    }

    @Override
    public void delete(Integer id) {

        String sql = "delete from t_article where id = ?";
        jdbcTemplate.update(sql,id);

    }
}
