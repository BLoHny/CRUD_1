package com.crud.login.contoller;

import com.crud.login.repository.UserRepository;
import com.crud.login.user.User;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(
            @RequestParam String nickname,
            @RequestParam String password,
            @RequestParam String email
    ) {
        return userRepository.save(new User(nickname, password, email));
    }

    @GetMapping("/AllUsers")
    public Iterable<User> list() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<User> findOne(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @PutMapping(value = "/{id}")
    public User update(
            @PathVariable Long id,
            @RequestParam String nickname,
            @RequestParam String password,
            @RequestParam String email
    ) {
        Optional<User> user = userRepository.findById(id);
        user.get().setNickname(nickname);
        user.get().setPassword(password);
        user.get().setEmail(email);

        return userRepository.save(user.get());
    }

    public void delete(@RequestParam Long id) {
        userRepository.deleteById(id);
    }
}
