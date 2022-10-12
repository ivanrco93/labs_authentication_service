package devforce.labs.authentication.usecase.user.impl;

import devforce.labs.authentication.dataprovider.UserProvider;
import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.query.entity.Query;
import devforce.labs.authentication.query.entity.WhereType;
import devforce.labs.authentication.query.matcher.CustomizedExampleMatcher;
import devforce.labs.authentication.usecase.user.RetrieveUser;
import devforce.labs.authentication.validator.user.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class RetrieveUserImpl implements RetrieveUser {
    private final UserValidator userValidator;
    private final UserProvider userProvider;

    @Autowired
    private CustomizedExampleMatcher<User> exampleCustomizedMatcher;

    @Autowired
    public RetrieveUserImpl(
            UserValidator userValidator,
            UserProvider userProvider
    ) {
        this.userValidator = userValidator;
        this.userProvider = userProvider;
    }

    @Override
    public List<User> retrieveAllUsers() {
        return userProvider.retrieveUsers();
    }

    @Override
    public User retrieveUserById(Integer id) {
        return userProvider.retrieveUserById(id);
    }

    @Override
    public User retrieveUserByUUId(String uuid) throws UserNotFoundException {
        return userProvider.retrieveUserByUUId(uuid);
    }

    @Override
    public User retrieveUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
        return userProvider.retrieveUserByEmailAndPassword(email, password);
    }

    @Override
    public List<User> retrieveAllUsers(User user) {
        List<Query> query = new ArrayList<Query>();
        Query q = new Query();
        q.setField("firstName");
        q.setValue("Ivan");
        q.setType("select");
        q.setWhereType(WhereType.AND);


        Query q2 = new Query();
        q2.setField("firstLastName");
        q2.setValue("Martinez");
        q2.setType("select");
        q2.setWhereType(WhereType.OR);

        Query q3 = new Query();
        q3.setField("status");
        q3.setValue("false");
        q3.setType("select");
        q3.setWhereType(WhereType.OR);

        query.add(q);
        query.add(q2);
        query.add(q3);

        return castObjectToUser(this.exampleCustomizedMatcher.findAllByFilters(query, User.class));
    }

    public List<User> castObjectToUser(List<Object> object){
        List<User> u = new ArrayList<User>();
        for(Object o: object){
            User tmpUser = (User)o;
            u.add(tmpUser);
        }
        return u;
    }
}
