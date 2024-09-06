package dooyaspring.boothello.cat.controller;

import dooyaspring.boothello.cat.model.Cat;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cats")
public class CatController {
    private final List<Cat> catList = new ArrayList<Cat>();

    public CatController() {
        catList.add(new Cat(1L, "Tom", "black", 2));
        catList.add(new Cat(2L, "Neo", "white", 3));
        catList.add(new Cat(3L, "Happy", "blue", 1));
    }

    @GetMapping
    public List<Cat> getAllCats() {
        return catList;
    }

    @GetMapping("/{id}")
    public Cat getCatById(@PathVariable Long id) {
        Optional<Cat> cat = catList.stream().filter(c -> c.getId().equals(id)).findFirst();
        return cat.orElse(null);
    }

    @PostMapping
    public Cat addCat(@RequestBody Cat cat) {
        cat.setId((catList.size() + 1L));
        catList.add(cat);
        return cat;
    }

    @DeleteMapping("/{id}")
    public String deleteCat(@PathVariable Long id) {
        boolean removed = catList.removeIf(c -> c.getId().equals(id));
        return removed ? "고양이 정보 삭제 완료" : "고양이를 찾지 못했습니다";
    }
}
