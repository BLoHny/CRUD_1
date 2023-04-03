package com.crud.login.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, length = 16)
    private String nickname;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false)
    private String email;
}
