package com.lagou.test;

import com.lagou.domain.Article;
import com.lagou.servlet.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {SpringConfig.class})

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class mybatisTest {
//    ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//    ArticleService articleService = (ArticleService) classPathXmlApplicationContext.getBean("articleService");

//    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
//    ArticleService articleService = applicationContext.getBean(ArticleService.class);

//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//    ArticleService articleService = applicationContext.getBean(ArticleService.class);
    @Autowired
    ArticleService articleService;
    //    private SqlSessionFactory sqlSessionFactory;
//    private SqlSession sqlSession;
//
//
//    // 在 @Test方法标注的方法执行之前来执行
//    @Before
//    public void before() throws IOException {
//        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//
//        sqlSession = sqlSessionFactory.openSession();
//    }
//
//
//    @After
//    public void after(){
//
//        sqlSession.commit();
//        sqlSession.close();
//
//    }
//
    @Test
    public void testSave() throws IOException {

        Article article=new Article();
        article.setContent("内容1");
        article.setTitle("标题");
        articleService.save(article);


    }

//    @Autowired
//    private JDKProxyFactory jdkProxyFactory;
//    @Test
//    public void testJDKProxy() throws Exception {
//        ArticleService accountServiceJdkProxy = jdkProxyFactory.createArticleSericeJDKProxy();
//        Article article=new Article();
//        article.setContent("内容2");
//        article.setTitle("标题");
//        accountServiceJdkProxy.save(article);
//    }

//    @Autowired
//    private CglibProxyFactory cglibProxyFactory;
//    @Test
//    public void testCglib() throws Exception {
//        ArticleService accountServiceCglibProxy = cglibProxyFactory.createArticleServiceCglibProxy();
//
//        Article article=new Article();
//        article.setContent("内容2");
//        article.setTitle("标题");
//        accountServiceCglibProxy.save(article);
//    }

}
