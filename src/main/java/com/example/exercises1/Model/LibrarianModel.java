package com.example.exercises1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibrarianModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must not be empty ")
    @Column(columnDefinition ="varchar(20) not null")
    private String name;

    @NotEmpty(message = "Username must not be empty ")
    @Column(columnDefinition ="varchar(20) not null")
    private String username;

    @NotEmpty(message = "Password must not be empty ")
    @Pattern(regexp = "(.+)(\\d+)(\\d|.)*|(\\d+)(.+)(\\d|.)*",message = "Password must be contains characters and digits")
    @Column(columnDefinition ="varchar(30) not null check(password REGEXP '(.+)(\\d+)(\\d|.)*|(\\d+)(.+)(\\d|.)*')")
    private String password;

    @Email(message = "Email must be a valid email")
    //@UniqueElements(message = "Email must be unique")
    @Column(columnDefinition ="varchar(30) not null unique check(email REGEXP '([a-zA-Z0-9]{6,})(@)([a-zA-Z]{6,})(\\.)([a-zA-Z]{2,})')")
    private String email;




}
