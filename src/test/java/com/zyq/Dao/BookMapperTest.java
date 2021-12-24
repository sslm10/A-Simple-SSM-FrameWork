package com.zyq.Dao;

import com.zyq.Pojo.Books;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class BookMapperTest {

    @Test
    public void addBook() throws IOException {
        //加载mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //建立会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取DAO对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //测试其中的方法
        int i = bookMapper.addBook(new Books(0, "百年孤独", "马尔克斯",2, "《百年孤独》，是哥伦比亚作家加西亚·马尔克斯创作的长篇小说，是其代表作，也是拉丁美洲魔幻现实主义文学的代表作，被誉为“再现拉丁美洲历史社会图景的鸿篇巨著”。"));
        sqlSession.commit();
        assertEquals(1,i);
    }

    @Test
    public void deleteBookById() throws IOException {
        //加载mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //建立会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取DAO对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //测试其中的方法
        int i = bookMapper.deleteBookById(1);
        sqlSession.commit();
        assertEquals(1,i);
    }

    @Test
    public void updateBook() throws IOException {
        //加载mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //建立会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取DAO对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //测试其中的方法
        int i = bookMapper.updateBook(new Books(2,"浮士德","歌德",3,"details"));
        sqlSession.commit();
        assertEquals(1,i);
    }

    @Test
    public void queryBookById() throws IOException {
        //加载mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //建立会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取DAO对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //测试其中的方法
        Books book = bookMapper.queryBookById(2);
        sqlSession.commit();
        System.out.println(book.toString());
    }

    @Test
    public void queryBookByAuthorName() throws IOException {
        //加载mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //建立会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取DAO对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //测试其中的方法
        List<Books> booksList = bookMapper.queryBookByAuthorName("马尔克斯");
        sqlSession.commit();
        for(Books books : booksList){
            System.out.println(books.toString());
        }
    }

    @Test
    public void queryAllBook() throws IOException {
        //加载mybatis配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //建立会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取DAO对象
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //测试其中的方法
        List<Books> booksList = bookMapper.queryAllBook();
        sqlSession.commit();
        for(Books books : booksList){
            System.out.println(books.toString());
        }
    }
}