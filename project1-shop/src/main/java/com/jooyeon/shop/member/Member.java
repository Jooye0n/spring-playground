package com.jooyeon.shop.member;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String displayName;

    Member(String username, String password, String displayName){
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }
}
