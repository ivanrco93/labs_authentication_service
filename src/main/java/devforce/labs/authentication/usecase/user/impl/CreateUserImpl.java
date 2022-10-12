package devforce.labs.authentication.usecase.user.impl;

import devforce.labs.authentication.dataprovider.UserProvider;
import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.InvalidUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.usecase.user.CreateUser;
import devforce.labs.authentication.validator.user.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserImpl implements CreateUser {
    private final UserValidator userValidator;
    private final UserProvider userProvider;

    @Autowired
    public CreateUserImpl(
            UserValidator userValidator,
            UserProvider userProvider
    ) {
        this.userValidator = userValidator;
        this.userProvider = userProvider;
    }

    @Override
    public User createUser(User user) throws InvalidUserException, DatabaseUserException, UserNotFoundException {
        userValidator.validateUser(user);
        User createdUser = userProvider.saveUser(user);
        return createdUser;
    }
}
