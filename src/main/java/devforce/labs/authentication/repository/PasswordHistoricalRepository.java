package devforce.labs.authentication.repository;

import devforce.labs.authentication.entity.PasswordHistorical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordHistoricalRepository extends JpaRepository<PasswordHistorical, Integer> {
    PasswordHistorical findByUserIdAndPassword(int userId, String password);
}
