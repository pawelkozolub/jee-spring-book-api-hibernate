package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/book/list")
    @ResponseBody
    public String getAll() {
        return bookDao.findAll().toString();
    }

    @RequestMapping("/book/{id}")
    @ResponseBody
    public String getBook(@PathVariable(name = "id") Long id) {
        return bookDao.findById(id).toString();
    }

    @RequestMapping("/book/update/{id}/{title}/{author}")
    @ResponseBody
    public String updateTitleAuthor(@PathVariable(name = "id") Long id,
                                    @PathVariable(name = "title") String title,
                                    @PathVariable(name = "author") String author) {
        Book book = bookDao.findById(id);
        book.setTitle(title);
        book.setAuthor(author);
        bookDao.update(book);
        return "Book updated:\n" + book.toString();
    }

    @RequestMapping("/book/add-sample-book")
    @ResponseBody
    public String addSampleBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        bookDao.save(book);
        return "Book added:\n" + book.toString();
    }
}
