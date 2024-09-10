package dooyaspring.boothello.book;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<BookDto> selectAllBooks();
    List<BookDto> searchBooks(String keyword);
}
