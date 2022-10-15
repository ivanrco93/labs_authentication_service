package devforce.labs.authentication.repository;

import devforce.labs.authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUuId(String uuId);
    User findByEmailAndPassword(String email, String password);
    User findByEmail(String email);
    User findByIdentification(String identification);

    User findByCode(String code);
}
