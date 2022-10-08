package devforce.labs.authentication.repository;

import devforce.labs.authentication.entity.PasswordRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRequestRepository extends JpaRepository<PasswordRequest, Integer> {
    PasswordRequest findByRequestId(String requestId);
    PasswordRequest deleteByRequestId(String requestId);
}
