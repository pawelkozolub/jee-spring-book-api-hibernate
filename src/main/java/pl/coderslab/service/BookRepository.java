package pl.coderslab.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
