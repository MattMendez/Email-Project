package com.DTO;

import com.Model.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEmails {

    List<Email> received;

    List<Email> sent;
}
