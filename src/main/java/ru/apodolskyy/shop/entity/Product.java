package ru.apodolskyy.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product{

    private Long id;
    private String item;
    private Integer price;

    public Product(String item) {
        this.id = 0L;
        this.item = item;
        this.price = null;
    }

}
