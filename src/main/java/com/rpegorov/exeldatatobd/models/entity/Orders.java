package com.rpegorov.exeldatatobd.models.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class describing Entity model for Orders
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "orders")
public class Orders implements Serializable {

    @Id
    private Long id;

    private String company;

    /**
     * Setting relationships between tables, setting a pointer to Orders in Product
     */
    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Product>products = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Orders orders = (Orders) o;
        return id != null && Objects.equals(id, orders.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
