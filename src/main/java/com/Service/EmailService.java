package com.Service;

import com.DTO.NewEmail;
import com.DTO.UserEmails;
import com.Model.Email;
import com.Repository.EmailRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public void saveEmail(NewEmail newEmail) {

        emailRepository.save(Email.builder()
                .receives(newEmail.getTo())
                .sends(newEmail.getFrom())
                .message(newEmail.getMessage())
                .content(newEmail.getContent())
                .dateTime(LocalDateTime.now())
                .build());
    }

    public UserEmails allEmails(String email){

        return UserEmails.builder()
                .received(emailRepository.findAllByReceives(email))
                .sent(emailRepository.findAllBySends(email))
                .build();
    }

}
