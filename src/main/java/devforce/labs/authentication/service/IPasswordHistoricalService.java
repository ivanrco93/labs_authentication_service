package devforce.labs.authentication.service;

import devforce.labs.authentication.entity.PasswordHistorical;

public interface IPasswordHistoricalService {
    PasswordHistorical searchByUserIdAndPassword(int userId, String password);
    void save(PasswordHistorical historical);
    void delete(int historicalId);
}
