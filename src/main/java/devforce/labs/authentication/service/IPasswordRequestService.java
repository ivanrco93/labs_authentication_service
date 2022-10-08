package devforce.labs.authentication.service;

import devforce.labs.authentication.entity.PasswordRequest;

public interface IPasswordRequestService {
    PasswordRequest searchByRequestId(String requestId);
    void save(PasswordRequest request);
    void deleteById(int id);
    void deleteByRequestId(String requestId);
}

