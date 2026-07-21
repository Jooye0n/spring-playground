package com.jooyeon.shop.comment;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column
    private String content;
    private Long parentId;

    Comment(String username, String content, Long parentId){
        this.username = username;
        this.content = content;
        this.parentId = parentId;
    }
}
