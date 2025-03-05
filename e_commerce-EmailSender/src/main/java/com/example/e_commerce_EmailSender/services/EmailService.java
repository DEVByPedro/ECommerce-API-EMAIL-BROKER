package com.example.e_commerce_EmailSender.services;

import com.example.e_commerce_EmailSender.enums.StatusEmail;
import com.example.e_commerce_EmailSender.models.EmailModel;
import com.example.e_commerce_EmailSender.repository.EmailRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

      @Autowired
      private EmailRepository repository;

      @Autowired
      private JavaMailSender mailSender;

      @Value("${spring.mail.username}")
      private String emailFrom;

      @Transactional
      public EmailModel sendEmail(EmailModel emailModel) {
            try {
                  emailModel.setSendDateTime(LocalDateTime.now());
                  emailModel.setEmailFrom(emailFrom);

                  SimpleMailMessage message = new SimpleMailMessage();
                  message.setTo(emailModel.getEmailTo());
                  message.setSubject(emailModel.getSubject());
                  message.setText(emailModel.getText());
                  mailSender.send(message);

                  emailModel.setStatusEmail(StatusEmail.SENT);
            } catch ( Exception e) {
                  emailModel.setStatusEmail(StatusEmail.ERROR);
            } finally {
                  return repository.save(emailModel);
            }
      }
}
