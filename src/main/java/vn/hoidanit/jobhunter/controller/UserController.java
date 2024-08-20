package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User createNewUser(@RequestBody User user) {

        User newUser = this.userService.handleCreateUser(user);
        return newUser;
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        this.userService.handleDeleteUser(id);
        return "deleteUser";
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {

        return this.userService.fetchUserById(id);

    }

    @GetMapping("/user")
    public List<User> getAllUsers() {

        return this.userService.fetchAllUsers();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {

        User updatedUser = this.userService.handleUpdateUser(user);
        return updatedUser;

    }
}
