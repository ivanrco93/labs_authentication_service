package devforce.labs.authentication.usecase.user;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.UserNotFoundException;

public interface UpdateUser {
    User updateUser(User user) throws UserNotFoundException, DatabaseUserException;
}
