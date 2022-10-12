package devforce.labs.authentication.implementation;

import devforce.labs.authentication.dataprovider.UserProvider;
import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.InvalidUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.repository.UserRepository;
import devforce.labs.authentication.service.IUserService;
import devforce.labs.authentication.usecase.user.CreateUser;
import devforce.labs.authentication.usecase.user.RetrieveUser;
import devforce.labs.authentication.validator.user.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private CreateUser createUser;

    @Autowired
    private RetrieveUser retrieveUser;
    @Override
    public List<User> retrieveUsers() {
        return retrieveUser.retrieveAllUsers();
    }

    @Override
    public List<User> retrieveUsers(User user)  {
        return retrieveUser.retrieveAllUsers(user);
    }

    @Override
    public User retrieveUserById(Integer id) {
        return retrieveUser.retrieveUserById(id);
    }

    @Override
    public User retrieveUserByUUID(String UUID) throws UserNotFoundException {
        return retrieveUser.retrieveUserByUUId(UUID);
    }

    @Override
    public User retrieveUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
        return retrieveUser.retrieveUserByEmailAndPassword(email, password);
    }

    @Override
    public User createUser(User user) throws InvalidUserException, DatabaseUserException, UserNotFoundException {
        return createUser.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }
}
