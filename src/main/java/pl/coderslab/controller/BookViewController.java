package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Book;
import pl.coderslab.service.BookService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/view/book")
public class BookViewController {

    private final BookService bookService;

    public BookViewController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "/books/list-view";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/books/add-view";
    }

    @PostMapping("/add")
    public String save(Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/books/add-view";
        }
        bookService.add(book);
        return "redirect:/view/book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "/books/edit-view";
    }

    @PostMapping("/edit")
    public String update(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/books/edit-view";
        }
        bookService.update(book);
        return "redirect:/view/book/list";
    }
}
