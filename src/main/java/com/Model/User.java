package com.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    private String name;

    private String lastName;

    private String address;

    private String phone;

    private String city;

    private String country;

    private String state;

    @Id
    @Column(unique = true)
    @NotBlank()
    @Email(message = "The Email must be valid")
    private String email;

    @Size(max = 30,min = 8)
    private String password;

}
