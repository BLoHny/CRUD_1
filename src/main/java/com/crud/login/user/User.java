package com.crud.login.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, length = 16)
    @Setter
    private String nickname;

    @Column(nullable = false, length = 20)
    @Setter
    private String password;

    @Column(nullable = false)
    @Setter
    private String email;

    public User(String nickname, String password, String email) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }
}
