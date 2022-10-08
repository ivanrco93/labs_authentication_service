package devforce.labs.authentication.implementation;

import devforce.labs.authentication.entity.User;
import devforce.labs.authentication.repository.UserRepository;
import devforce.labs.authentication.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> searchAll() {
        return userRepository.findAll();
    }

    @Override
    public User searchById(int id) {
        Optional<User> user =  userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public User searchByUUID(String UUID) {
        return userRepository.findByUuId(UUID);
    }

    @Override
    public User searchByEmailAndPassword(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User save(User user) {
        userRepository.save(user);
        return searchById(user.getId());
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }
}
