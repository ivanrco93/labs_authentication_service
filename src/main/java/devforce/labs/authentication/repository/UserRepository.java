package devforce.labs.authentication.repository;

import devforce.labs.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUuId(String uuId);
    User findByEmailAndPassword(String email, String password);
}
