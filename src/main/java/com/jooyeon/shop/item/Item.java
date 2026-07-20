package com.jooyeon.shop.item;

import jakarta.persistence.*;
import lombok.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer price;
    private String userName;

    Item(String title, Integer price, String userName){
        this.title = title;
        this.price = price;
        this.userName = userName;
    }
}


