package devforce.labs.authentication.dataprovider.impl;

import devforce.labs.authentication.dataprovider.UserProvider;
import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.exception.DatabaseUserException;
import devforce.labs.authentication.exception.UserNotFoundException;
import devforce.labs.authentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserProviderImpl implements UserProvider {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> retrieveUsers() {
        return userRepository.findAll();
    }

    @Override
    public User retrieveUserById(Integer id) {
        Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User retrieveUserByUUId(String uuid) throws UserNotFoundException {
        return userRepository.findByUuId(uuid).orElseThrow(
                ()-> new UserNotFoundException("User not found")
        );
    }

    @Override
    public User retrieveUserByEmailAndPassword(String email, String password) throws UserNotFoundException {
        User user = userRepository.findByEmailAndPassword(email, password);
        if(user!=null){
            return user;
        }else{
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public User saveUser(User user) throws DatabaseUserException, UserNotFoundException {
        try {
            userRepository.save(user);
            Optional<User> optionalUser = userRepository.findByUuId(user.getUuId());
            if(optionalUser.isPresent()) {
                return optionalUser.get();
            }else{
                throw new UserNotFoundException("User record not registered in database");
            }
        } catch (JpaSystemException | DataIntegrityViolationException ex){
            throw new DatabaseUserException(ex.getMessage());
        }
    }

    @Override
    public Boolean deleteUser(Integer id) {
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }

    @Override
    public List<User> retrieveUsers(Example<User> user) {
        return userRepository.findAll(user);
    }
}
