package net.mdsgene.admin.admintool.business;

import net.mdsgene.admin.admintool.dal.EmailRepository;
import net.mdsgene.admin.admintool.entities.EmailEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public EmailEntity save(EmailMessage emailMessage) {
        EmailEntity email = new EmailEntity();
        email.setName(emailMessage.getName());
        email.setInstitution(emailMessage.getInstitution());
        email.setAddress(emailMessage.getAddress());
        email.setCountry(emailMessage.getCountry());
        email.setMessage(emailMessage.getMessage());
        email.setEmail(emailMessage.getEmail());
        email.setSubject(emailMessage.getSubject());

        return emailRepository.save(email);
    }

}
