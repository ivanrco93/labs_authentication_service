package devforce.labs.authentication.controller;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.InvalidUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.service.IUserService;
import devforce.labs.authentication.swagger.UserControllerSwagger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authentication-api/v1/users")
public class UserController implements UserControllerSwagger {
    @Autowired
    private IUserService userService;

    @Override
    @GetMapping
    public ResponseEntity<Object> retrieveAllUsers() {
        return ResponseEntity.ok(userService.retrieveUsers());
    }

    @Override
    @GetMapping("/search/filter")
    public ResponseEntity<Object> retrieveFilteredUsers(
            //@ModelAttribute("search") User user,
            @RequestBody User user,
            HttpServletRequest httpServletRequest
    ) {
        return ResponseEntity.ok(userService.retrieveUsers(user));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieveUserById(
            @PathVariable Integer id,
            HttpServletRequest httpServletRequest
    ) {
        return ResponseEntity.ok(userService.retrieveUserById(id));
    }

    @Override
    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<Object> retrieveUserByUUID(
            @PathVariable String uuid,
            HttpServletRequest httpServletRequest
    ) throws UserNotFoundException {
        return ResponseEntity.ok(userService.retrieveUserByUUID(uuid));
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> createUser(
            @RequestBody User user,
            HttpServletRequest httpServletRequest) throws DatabaseUserException, InvalidUserException, UserNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @Override
    @PutMapping
    public ResponseEntity<Object> updateUser(User user, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(userService.updateUser(user));
    }
}
