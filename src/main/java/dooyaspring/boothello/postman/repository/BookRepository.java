package dooyaspring.boothello.postman.repository;

import dooyaspring.boothello.postman.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
