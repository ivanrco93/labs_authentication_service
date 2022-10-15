package devforce.labs.authentication.validator.user.impl;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.InvalidUserException;
import devforce.labs.authentication.validator.user.UserValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@PropertySource("classpath:configuration.properties")
public class UserValidatorImpl implements UserValidator {

    @Override
    public void validateUser(User user) throws InvalidUserException {
        //throw new InvalidUserException(MessageFormat.format("Provided firstname length [{0}] is greater than allowed [{1}]", firstNameLength, firstNameMaxLength));
    }
}
