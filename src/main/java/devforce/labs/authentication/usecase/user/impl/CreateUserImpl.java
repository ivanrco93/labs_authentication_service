package devforce.labs.authentication.usecase.user.impl;

import devforce.labs.authentication.dataprovider.EmailProvider;
import devforce.labs.authentication.dataprovider.UserProvider;
import devforce.labs.authentication.entity.EmailDetails;
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
    @Autowired
    private UserProvider userProvider;

    @Autowired
    private EmailProvider emailProvider;

    @Override
    public User createUser(User user) throws InvalidUserException, DatabaseUserException, UserNotFoundException {
        if(userProvider.retrieveUserByEmail(user.getEmail())==null) {
            if(userProvider.retrieveUserByIdentification(user.getIdentification())==null) {
                if(userProvider.retrieveUserByCode(user.getCode())==null) {
                    User createdUser = userProvider.saveUser(user);
                    emailProvider.sendSimpleMail(new EmailDetails(
                    "ivandcastiblanco@gmail.com", "User created", "Labs: user created", null
                    ));
                    return createdUser;
                }else{
                    throw new InvalidUserException("Ya existe un usuario con este código");
                }
            }else{
                throw new InvalidUserException("Ya existe un usuario con este número de identificación");
            }
        }else{
            throw new InvalidUserException("Ya existe un usuario con este correo");
        }
    }
}
