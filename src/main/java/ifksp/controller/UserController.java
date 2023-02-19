package ifksp.controller;

import ifksp.dto.CreateUserCommand;
import ifksp.dto.UpdateUserCommand;
import ifksp.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ifksp.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<UserDto> addUser(@RequestBody CreateUserCommand command) {
        return userService.addUser(command);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserCommand command) {
        return userService.updateUser(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> updateUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }
}
