package dooyaspring.boothello.controller;

import dooyaspring.boothello.dto.UserDto;
import dooyaspring.boothello.entity.UserEntity;
import dooyaspring.boothello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserEntity create(@RequestBody UserDto userDto) throws Exception {
        return userService.createUser(userDto);
//        return userService.createWithRollback(userDto);
    }

    @GetMapping
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public UserEntity update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }
}
