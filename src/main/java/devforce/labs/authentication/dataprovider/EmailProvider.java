package devforce.labs.authentication.dataprovider;

import devforce.labs.authentication.entity.EmailDetails;

public interface EmailProvider {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}
