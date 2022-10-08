package devforce.labs.authentication.implementation;

import devforce.labs.authentication.entity.PasswordRequest;
import devforce.labs.authentication.repository.PasswordRequestRepository;
import devforce.labs.authentication.service.IPasswordRequestService;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordRequestService implements IPasswordRequestService {
    @Autowired
    private PasswordRequestRepository passwordRequestRepository;

    @Override
    public PasswordRequest searchByRequestId(String requestId) {
        return passwordRequestRepository.findByRequestId(requestId);
    }

    @Override
    public void save(PasswordRequest request) {
        passwordRequestRepository.save(request);
    }

    @Override
    public void deleteById(int id) {
        passwordRequestRepository.deleteById(id);
    }

    @Override
    public void deleteByRequestId(String requestId) {
        passwordRequestRepository.deleteByRequestId(requestId);
    }
}
