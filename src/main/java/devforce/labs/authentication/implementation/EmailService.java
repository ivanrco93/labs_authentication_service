package devforce.labs.authentication.implementation;

import devforce.labs.authentication.dataprovider.EmailProvider;
import devforce.labs.authentication.entity.EmailDetails;
import devforce.labs.authentication.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailService implements IEmailService {
    @Autowired
    private EmailProvider emailProvider;

    @Override
    public String sendSimpleMail(EmailDetails details)
    {
        return emailProvider.sendSimpleMail(details);
    }

    @Override
    public String
    sendMailWithAttachment(EmailDetails details)
    {
        return emailProvider.sendMailWithAttachment(details);
    }
}
