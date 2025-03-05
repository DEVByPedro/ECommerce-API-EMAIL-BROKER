package com.example.e_commerce_EmailSender.models;

import com.example.e_commerce_EmailSender.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ms-email-sender-ecommerce")
@Getter
@Setter
public class EmailModel {

      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      private UUID emailId;
      private UUID userId;
      private String emailFrom;
      private String emailTo;
      private String subject;

      @Column(columnDefinition = "TEXT")
      private String text;
      private LocalDateTime sendDateTime;
      private StatusEmail statusEmail;

}
