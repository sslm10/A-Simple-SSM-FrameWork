import com.zyq.Pojo.Books;
import com.zyq.Service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test01 {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取到了spring容器中的对象
        BookService bookService = (BookService) applicationContext.getBean("BookServiceImpl");
//        bookService.addBook(new Books(0,"呼啸山庄","勃朗特",1,"《呼啸山庄》通过一个爱情悲剧，向人们展示了一幅畸形社会的生活画面，勾勒了被这个畸形社会扭曲了的人性及其造成的种种恐怖的事件。"));

        // spring和mybatis整合在一起使用，事务是自动提交的
        List<Books> booksList = bookService.queryAllBook();
        booksList.forEach(books-> System.out.println(books));
    }
}
