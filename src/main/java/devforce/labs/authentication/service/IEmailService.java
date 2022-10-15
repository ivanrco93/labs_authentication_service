package devforce.labs.authentication.service;

import devforce.labs.authentication.entity.EmailDetails;

public interface IEmailService {
    String sendSimpleMail(EmailDetails details);
    String sendMailWithAttachment(EmailDetails details);
}