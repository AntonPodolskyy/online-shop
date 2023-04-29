package ru.apodolskyy.shop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name = "customer_data", schema = "customers", catalog = "onlineshop_customers")
public class Customer {

    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", updatable = false)
    private Long id;

    @Basic
    @Column(name = "customer_name", nullable = false, length = -1)
    private String customerName;

    @Basic
    @Column(name = "customer_surname", nullable = false, length = -1)
    private String customerSurname;

    @Basic
    @Column(name = "customer_email", nullable = false, length = -1)
    private String customerEmail;

    @Basic
    @Column(name = "customer_password", nullable = false, length = -1)
    private String customerPassword;

    /**
     * User can have only 1 role
     */
    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER)
    private CustomerRole customerRole;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer that = (Customer) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return customerEmail;
    }
}
