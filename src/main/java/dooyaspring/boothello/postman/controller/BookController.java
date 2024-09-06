package dooyaspring.boothello.postman.controller;

import dooyaspring.boothello.postman.model.Book;
import dooyaspring.boothello.postman.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Book addBook(@RequestBody  Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book book1 = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setPublishedYear(book.getPublishedYear());
        book1.setGenre(book.getGenre());
        return bookRepository.save(book1);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "Book Deleted";
    }
}
