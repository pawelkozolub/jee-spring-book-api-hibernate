package pl.coderslab.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    // injection via class constructor > note also that we use interphase here, not a specific implementation
    // such as MockBookService > in future it allows us to change MockBookService into other e.g. FileBookService
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getList() {
        log.info("Get all books");
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable(name = "id") Long id) {
        log.info("Get book with id: {}", id);
        return bookService.get(id).orElse(null);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        log.info("Add book: {}", book.toString());
        bookService.add(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(name = "id") Long id) {
        log.info("Delete book with id: {}", id);
        bookService.delete(id);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book) {
        log.info("Update book: {}", book.toString());
        bookService.update(book);
    }

    // helloBook() is used for testing
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(
                1L,
                "9788324631766",
                "Thinking in Java",
                "Bruce Eckel",
                "Helion",
                "programming");
    }
}
