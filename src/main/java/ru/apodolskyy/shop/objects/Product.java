package ru.apodolskyy.shop.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.apodolskyy.shop.interfaces.IProduct;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements IProduct {


    public String item;
    public Integer price;

    public Product(String item) {
        this.item = item;
        this.price = null;
    }

}
