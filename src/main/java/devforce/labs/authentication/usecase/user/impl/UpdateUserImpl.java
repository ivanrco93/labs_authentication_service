package devforce.labs.authentication.usecase.user.impl;

import devforce.labs.authentication.dataprovider.UserProvider;
import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.usecase.user.UpdateUser;
import devforce.labs.authentication.validator.user.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateUserImpl implements UpdateUser {
    private final UserValidator userValidator;
    private final UserProvider userProvider;

    @Autowired
    public UpdateUserImpl(
            UserValidator userValidator,
            UserProvider userProvider
    ) {
        this.userValidator = userValidator;
        this.userProvider = userProvider;
    }

    @Override
    public User updateUser(User user) throws UserNotFoundException, DatabaseUserException {
        User userToDelete = userProvider.retrieveUserById(user.getId());
        if(userToDelete!=null){
            return userProvider.saveUser(user);
        }else{
            throw new UserNotFoundException("User not found");
        }
    }
}
