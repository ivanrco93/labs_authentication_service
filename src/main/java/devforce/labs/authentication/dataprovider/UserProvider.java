package devforce.labs.authentication.dataprovider;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import org.springframework.data.domain.Example;

import java.util.List;

public interface UserProvider {
    List<User> retrieveUsers();

    User retrieveUserById(Integer id);
    User retrieveUserByUUId(String uuid) throws UserNotFoundException;

    User retrieveUserByEmailAndPassword(String email, String password) throws UserNotFoundException;
    User retrieveUserByEmail(String email);

    User retrieveUserByIdentification(String identification);
    User retrieveUserByCode(String code);

    User saveUser(User user) throws DatabaseUserException, UserNotFoundException;

    Boolean deleteUser(Integer id);

    List<User> retrieveUsers(Example<User> user);
}
