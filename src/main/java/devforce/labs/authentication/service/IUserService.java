package devforce.labs.authentication.service;

import devforce.labs.authentication.entity.User;

import java.util.List;

public interface IUserService {
    List<User> searchAll();
    User searchById(int id);
    User searchByUUID(String UUID);
    User searchByEmailAndPassword(String email, String password);
    User save(User user);
    void delete(int userId);
}
