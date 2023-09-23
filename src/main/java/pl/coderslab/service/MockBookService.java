package pl.coderslab.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
public class MockBookService implements BookService {
    private List<Book> list;
    private static Long idUsed = 0L;

    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(setId(), "9788324631766","Thinking in Java",
                "Bruce Eckel", "Helion", "programming"));
        list.add(new Book(setId(), "9788324627738", "Rusz glowa Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(setId(), "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    private Long setId() {
        return ++idUsed;
    }

    @Override
    public List<Book> getBooks() {
        return list;
    }

    @Override
    public Optional<Book> get(Long id) {
        return list.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

    @Override
    public void add(Book book) {
        book.setId(this.setId());
        list.add(book);
    }

    @Override
    public void delete(Long id) {
        if (this.get(id).isPresent()) {
            list.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        // book id is assumed to be unique > rest of book fields can be updated
        if (this.get(book.getId()).isPresent()) {
            int indexOfBookToUpdate = list.lastIndexOf(this.get(book.getId()).get());
            list.set(indexOfBookToUpdate, book);
        }
    }
}
