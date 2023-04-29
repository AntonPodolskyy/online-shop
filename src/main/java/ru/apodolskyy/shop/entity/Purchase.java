package ru.apodolskyy.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
@Entity
@Table(name = "purchase_data", schema = "purchase", catalog = "onlineshop_purchase")
public class Purchase {

    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", updatable = false)
    private Long id;

    /**
     * One “Customer” can have a couple of “Purchase”. No connection—different DBs.
     */
    @Column(name = "customer_id")
    private Long customerId;

    /**
     * In BD 1 or 0, converting to Boolean
     */
    @Basic
    @Column(name = "on_delivery")
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private Boolean onDelivery = false;

    /**
     * In BD 1 or 0, converting to Boolean
     */
    @Basic
    @Column(name = "paid")
    @Convert(converter = org.hibernate.type.NumericBooleanConverter.class)
    private Boolean paid = false;

    /**
     * Self updating by trigger in DB
     */
    @Setter(AccessLevel.NONE)
    @Basic
    @Column(name = "purchase_price")
    private Double purchasePrice;

    /**
     * Auto on creation, by trigger in DB
     */
    @Setter(AccessLevel.NONE)
    @Basic
    @Column(name = "purchase_time", updatable = false)
    private Timestamp purchaseTime;

    @Basic
    @Column(name = "purchase_remark", nullable = true, length = -1)
    private String purchaseRemark;

    /**
     * Single “Purchase” can consist a couple of “PurchasedProducts"
     */
    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    private List<PurchasedProducts> purchasedProducts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase that = (Purchase) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
