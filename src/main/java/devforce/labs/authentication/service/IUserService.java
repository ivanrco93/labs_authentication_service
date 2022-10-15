package devforce.labs.authentication.service;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.InvalidUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.query.entity.Query;

import java.util.List;

public interface IUserService {
    List<User> retrieveUsers();

    List<User> retrieveUsers(List<Query> query);
    User retrieveUserById(Integer id);
    User retrieveUserByUUID(String UUID) throws UserNotFoundException;
    User retrieveUserByEmailAndPassword(String email, String password) throws UserNotFoundException;
    User createUser(User user) throws InvalidUserException, DatabaseUserException, UserNotFoundException;

    User updateUser(User user);
    boolean deleteUser(int userId);
}
