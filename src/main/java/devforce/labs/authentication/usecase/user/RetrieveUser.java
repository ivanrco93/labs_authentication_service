package devforce.labs.authentication.usecase.user;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.UserNotFoundException;

import java.util.List;

public interface RetrieveUser {
    List<User> retrieveAllUsers();
    User retrieveUserById(Integer id);
    User retrieveUserByUUId(String uuid) throws UserNotFoundException;

    User retrieveUserByEmailAndPassword(String email, String password) throws UserNotFoundException;

    List<User> retrieveAllUsers(User user);
}
