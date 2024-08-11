package unibl.etf.ip.fitnessappbackend.services;

import jakarta.mail.internet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import unibl.etf.ip.fitnessappbackend.models.Category;
import unibl.etf.ip.fitnessappbackend.models.Program;
import unibl.etf.ip.fitnessappbackend.models.Subscription;
import unibl.etf.ip.fitnessappbackend.repositories.ProgramRepository;
import unibl.etf.ip.fitnessappbackend.repositories.SubscriptionRepository;
import unibl.etf.ip.fitnessappbackend.repositories.UserRepository;

@Service
public class MailService {

    private final JavaMailSender mailSender;

    private ProgramRepository programRepository;
    private SubscriptionRepository subscriptionRepository;
    private UserRepository userRepository;


    @Value("${spring.mail.username}")
    private String fromMail;

    @Value("${account.verification.url}")
    private String accountVerificationUrl;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    public void sendVerificationEmail(String username, String to) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            var helper = new MimeMessageHelper(message, true);
            helper.setSubject("Account verification - Fitness World");
            ClassPathResource htmlPath = new ClassPathResource("Verification.html");
            var html = Files.readString(Path.of(htmlPath.getFile().getAbsolutePath()));
            html = html.replace("validation.url", accountVerificationUrl + username);
            helper.setText(html, true);
            helper.setFrom(fromMail);
            helper.setTo(to);
            this.mailSender.send(message);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
    @Async
    public void sendInfoMail(String mail, String to) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromMail);
            message.setTo(to);
            message.setSubject("New Daily Fitness Programs");
            message.setText(mail);
            this.mailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    @Scheduled(cron = "0 59 23 * * *")
    public void sendEmailNotification(){
        List<Subscription> users = subscriptionRepository.findAll();
        LocalDate current = LocalDate.now();
        Date sqlDate = Date.valueOf(current);
        for(Subscription user:users){
            String username=user.getUsername();
            String categoryName = user.getCategoryName();
            List<Program> programs=programRepository.findAllByCategoryName(categoryName);
            if(!programs.isEmpty()) {
                StringBuilder builder = new StringBuilder("New programs for the whole day!" +
                        " Category you are subscribed to: \""+categoryName+"\":\n");
                for (Program program : programs)
                    builder.append("\t" + program.getName() + "\n");
                sendInfoMail(builder.toString(),userRepository.findByUsername(username).get().getEmail());
            }


        }
    }
}
