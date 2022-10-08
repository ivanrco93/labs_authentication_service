package devforce.labs.authentication.implementation;

import devforce.labs.authentication.entity.PasswordHistorical;
import devforce.labs.authentication.repository.PasswordHistoricalRepository;
import devforce.labs.authentication.service.IPasswordHistoricalService;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordHistoricalService implements IPasswordHistoricalService {
    @Autowired
    private PasswordHistoricalRepository passwordHistoricalRepository;
    @Override
    public PasswordHistorical searchByUserIdAndPassword(int userId, String password) {
        return passwordHistoricalRepository.findByUserIdAndPassword(userId, password);
    }

    @Override
    public void save(PasswordHistorical historical) {
        passwordHistoricalRepository.save(historical);
    }

    @Override
    public void delete(int historicalId) {
        passwordHistoricalRepository.deleteById(historicalId);
    }
}
