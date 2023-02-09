package ru.apodolskyy.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

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


    // TODO желательно еще задать сравнение в объектах, которые участвуют в коллекциях, как у нас
    // Например по id, и тогда во всем местах, где идет поиск/сравнение - сразу будет отрабатывать equals и hashCode - сильно сокращает код


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
