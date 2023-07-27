package com.satya.mongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private int id;
    private int price;
    private String code;
    private Brand brand;
    private Color color;
    private Category category;
}
