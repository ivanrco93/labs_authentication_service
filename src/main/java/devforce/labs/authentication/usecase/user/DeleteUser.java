package devforce.labs.authentication.usecase.user;

import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.UserNotFoundException;

public interface DeleteUser {
    boolean deleteUser(Integer id) throws DatabaseUserException, UserNotFoundException;
}
