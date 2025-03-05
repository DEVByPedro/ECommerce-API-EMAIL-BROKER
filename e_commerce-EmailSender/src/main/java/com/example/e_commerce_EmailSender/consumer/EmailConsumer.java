package com.example.e_commerce_EmailSender.consumer;

import com.example.e_commerce_EmailSender.dto.EmailDTO;
import com.example.e_commerce_EmailSender.models.EmailModel;
import com.example.e_commerce_EmailSender.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

      @Autowired
      private EmailService emailService;

      @RabbitListener(queues = "${broker.queue.email.name}")
      public void listenerEmailQueue(@Payload EmailDTO data) {
            EmailModel emailModel = new EmailModel();
            BeanUtils.copyProperties(data, emailModel);
            emailService.sendEmail(emailModel);
      }
}
