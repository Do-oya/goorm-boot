package dooyaspring.boothello.book;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {

    // 모든 책 조회
    List<BookDto> selectAllBooks();

    // ID로 특정 책 조회
    BookDto selectBookById(@Param("id") Long id);

    // 책 생성
    void insertBook(BookDto bookDto);

    // 책 업데이트
    void updateBook(BookDto bookDto);

    // ID로 책 삭제
    void deleteBookById(@Param("id") Long id);
}
