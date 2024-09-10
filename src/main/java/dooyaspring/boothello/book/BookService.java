package dooyaspring.boothello.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookMapper bookMapper;

    public BookService(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<BookDto> getAllBooks() {
        return bookMapper.selectAllBooks();
    }

    public List<BookDto> searchBooks(String keyword) {
        return bookMapper.searchBooks(keyword);
    }
}