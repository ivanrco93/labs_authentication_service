package devforce.labs.authentication.validator.user;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.InvalidUserException;

public interface UserValidator {
    void validateUser(User user) throws InvalidUserException;
}
