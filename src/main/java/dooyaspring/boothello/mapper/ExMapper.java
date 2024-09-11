package dooyaspring.boothello.mapper;

import dooyaspring.boothello.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface ExMapper {
    HashMap<String, Object> findById(HashMap<String, Object> paramMap);

//    void registerItem(HashMap<String, Object> paramMap);
    void registerItem(ItemDto itemDto);
}
