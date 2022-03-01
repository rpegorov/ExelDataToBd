package com.rpegorov.exeldatatobd.models.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

}
