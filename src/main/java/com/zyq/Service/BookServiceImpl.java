package com.zyq.Service;

import com.zyq.Dao.BookMapper;
import com.zyq.Pojo.Books;

import java.util.List;

public class BookServiceImpl implements BookService{

    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }
    public int addBook(Books book) {
        return bookMapper.addBook(book);
    }
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }
    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }
    public List<Books> queryBookByAuthorName(String authorName) {return bookMapper.queryBookByAuthorName(authorName);}
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}