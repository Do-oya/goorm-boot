package dooyaspring.boothello.usertest.controller;

import dooyaspring.boothello.usertest.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import dooyaspring.boothello.usertest.repository.UserRepository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @PostMapping
    public Users addUser(@RequestBody Users users) {
        return userRepository.save(users);
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "User Deleted";
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users userDetails) {
        Users user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }
}
