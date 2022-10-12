package devforce.labs.authentication.usecase.user.impl;

import devforce.labs.authentication.dataprovider.UserProvider;
import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.usecase.user.DeleteUser;
import devforce.labs.authentication.validator.user.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class DeleteUserImpl implements DeleteUser {
    private final UserValidator userValidator;
    private final UserProvider userProvider;

    @Autowired
    public DeleteUserImpl(
            UserValidator userValidator,
            UserProvider userProvider
    ) {
        this.userValidator = userValidator;
        this.userProvider = userProvider;
    }

    @Override
    public boolean deleteUser(Integer id) throws DatabaseUserException, UserNotFoundException {
        User userToDelete = userProvider.retrieveUserById(id);
        if(userToDelete!=null){
            return userProvider.deleteUser(id);
        }else{
            throw new UserNotFoundException("User not found");
        }
    }
}
