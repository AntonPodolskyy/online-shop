package ru.apodolskyy.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Entity
@Table(name = "product_data", schema = "purchase", catalog = "onlineshop_purchase")
public class Product {

    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", updatable = false)
    private Long id;

    /**
     * Product name
     */
    @Basic
    @Column(name = "item", nullable = false, length = -1)
    private String item;

    /**
     * Product price
     */
    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "remark", nullable = true, length = -1)
    private String remark;

    /**
     * Single Product can be part of couple PurchasedProducts
     */
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<PurchasedProducts> purchasedProducts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return item;
    }
}
