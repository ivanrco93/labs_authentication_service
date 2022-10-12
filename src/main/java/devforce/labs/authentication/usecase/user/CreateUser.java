package devforce.labs.authentication.usecase.user;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.InvalidUserException;
import devforce.labs.authentication.exception.UserNotFoundException;

public interface CreateUser {
    User createUser(User user) throws InvalidUserException, DatabaseUserException, UserNotFoundException;
}
