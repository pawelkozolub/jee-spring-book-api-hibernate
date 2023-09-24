package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.model.BookDao;

@Controller
public class BookDaoController {

    private final BookDao bookDao;

    public BookDaoController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping("/book/add-sample-book")
    @ResponseBody
    public String addSampleBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        bookDao.save(book);
        return "Sample book with id: " + book.getId();
    }
}
