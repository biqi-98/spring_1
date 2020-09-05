package com.lagou.servlet.impl;

import com.lagou.dao.ArticleDao;
import com.lagou.domain.Article;
import com.lagou.servlet.ArticleService;
//import com.lagou.utils.BeanFactory;
import com.lagou.utils.TranManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("articleService")  //相当于配置了bean标签  id属性
//@Scope("singleton")
@Service
public class ArticleServiceImpl implements ArticleService {
//    @Resource(name = "articleDao")
    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TranManager transactionManager;

//    public void setArticleDao(ArticleDao articleDao) {
//        this.articleDao = articleDao;
//    }

    @Override
    public void save(Article article) {
        // 调用dao层的save方法
//        articleDao = (ArticleDao) BeanFactory.getBean("articleDao");
//        articleDao = new ArticleDaoImpl();



        try {
            // 1.开启事务
            transactionManager.begin();
            // 2.业务操作
            articleDao.save(article);
            // 3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // 4.回滚事务
            transactionManager.rollback();
        } finally {
            transactionManager.release();
        }
    }
}
