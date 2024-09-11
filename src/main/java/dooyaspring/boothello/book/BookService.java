package dooyaspring.boothello.book;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public BookEntity createBook(BookDto bookDto) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setPublisher(bookDto.getPublisher());
        bookEntity.setPublishedDate(bookDto.getPublishedDate());
        bookEntity.setGenre(bookDto.getGenre());
        return bookRepository.save(bookEntity);
    }

    @Transactional(readOnly = true)
    public BookEntity getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public BookEntity updateBook(Long id, BookDto bookDto) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookEntity.setTitle(bookDto.getTitle());
        bookEntity.setAuthor(bookDto.getAuthor());
        bookEntity.setPublisher(bookDto.getPublisher());
        bookEntity.setPublishedDate(bookDto.getPublishedDate());
        bookEntity.setGenre(bookDto.getGenre());
        return bookRepository.save(bookEntity);
    }

    @Transactional
    public BookEntity deleteBook(Long id) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        bookRepository.delete(bookEntity);
        return bookEntity;
    }
}
