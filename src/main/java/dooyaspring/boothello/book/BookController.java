package dooyaspring.boothello.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/search")
    public List<BookDto> searchBooks(@RequestParam String keyword) {
        return bookService.searchBooks(keyword);
    }
}
