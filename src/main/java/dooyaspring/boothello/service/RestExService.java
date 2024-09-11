package dooyaspring.boothello.service;

import dooyaspring.boothello.dto.ItemDto;
import dooyaspring.boothello.entity.ItemEntity;
import dooyaspring.boothello.mapper.ExMapper;
import dooyaspring.boothello.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class RestExService {
    private final ExMapper exMapper;

    private final ItemRepository itemRepository;

    public RestExService(ExMapper exMapper, ItemRepository itemRepository) {
        this.exMapper = exMapper;
        this.itemRepository = itemRepository;
    }

    public boolean registerItem(ItemDto itemDto) {

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());
        itemRepository.save(itemEntity);

        log.info("service: register...");
        return true;
    }

    public ItemDto getItem(String id) {

        ItemEntity itemEntity = itemRepository.findById(id).get();

        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());

        return itemDto;
    }
}
