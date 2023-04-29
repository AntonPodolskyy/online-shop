package ru.apodolskyy.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONE)
@Entity
@Table(name = "purchased_products", schema = "purchase", catalog = "onlineshop_purchase")
public class PurchasedProducts {

    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * Couple of "PurchasedProducts" relating to 1 "Purchase"
     */
    @ManyToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    private Purchase purchase;

    /**
     * Couple of "PurchasedProducts" relating to 1 "Product"
     */
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    /**
     * Actual price taking from "Product" during creation "PurchasedProducts"
     */
    @Basic
    @Column(name = "product_price", nullable = false, precision = 0)
    private Double productPrice;

    @Basic
    @Column(name = "product_qty", nullable = false, precision = 0)
    private Double productQty;

    /**
     * Counting by trigger in DB
     */
    @Setter(AccessLevel.NONE)
    @Basic
    @Column(name = "total_amount", nullable = true, precision = 0)
    private Double totalAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchasedProducts that = (PurchasedProducts) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
