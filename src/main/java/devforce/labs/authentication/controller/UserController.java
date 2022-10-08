package devforce.labs.authentication.controller;

import devforce.labs.authentication.entity.User;
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
        return ResponseEntity.ok(userService.searchAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieveUserById(
            String id,
            HttpServletRequest httpServletRequest
    ) {
        return ResponseEntity.ok(userService.searchAll());
    }

    @Override
    @GetMapping("/uuid/{uuid}")
    public ResponseEntity<Object> retrieveUserByUUID(
            @PathVariable String UUID,
            HttpServletRequest httpServletRequest
    ) {
        return ResponseEntity.ok(userService.searchByUUID(UUID));
    }

    @Override
    @PostMapping
    public ResponseEntity<Object> createUser(
            @RequestBody User user,
            HttpServletRequest httpServletRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @Override
    @PutMapping
    public ResponseEntity<Object> updateUser(User user, HttpServletRequest httpServletRequest) {
        return ResponseEntity.ok(userService.save(user));
    }
}
