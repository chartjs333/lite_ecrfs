package net.mdsgene.admin.controllers;
import net.mdsgene.admin.admintool.business.EmailMessage;
import net.mdsgene.admin.admintool.business.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/contact")
    public String contact(ModelMap model) {
        EmailMessage message = new EmailMessage();
        model.addAttribute("message", message);
        return "contact";
    }

    // We use ConcurrentHashMap for thread-safety. It stores "IP" and "last access time"
    private ConcurrentHashMap<String, LocalDateTime> ipStore = new ConcurrentHashMap<>();

    @PostMapping("/contact")
    public String messages(ModelMap model, HttpServletRequest request) {
        EmailMessage message = (EmailMessage) model.get("message");
        String ipAddress = request.getRemoteAddr(); // Get client IP address
        LocalDateTime lastAccess = ipStore.get(ipAddress); // Get the last access time of this IP address

        if (lastAccess != null) {
            // Calculate the time difference
            long diffInMinutes = java.time.Duration.between(lastAccess, LocalDateTime.now()).toMinutes();

            // If the time difference less than 5 minutes, then return an error message
            if (diffInMinutes < 5) {
                model.addAttribute("errorMessage", "Too many requests. Please wait for some time.");
                return "contactErrorMessage";
            }
        }

        // Update the last access time
        ipStore.put(ipAddress, LocalDateTime.now());

        // If not, then continue with the process
        try {
            emailService.save(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "contactSuccess";
    }
}
