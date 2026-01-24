package com.faheem.ecommerce.category;

import com.faheem.ecommerce.product.Product;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Remove;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Product> products;
}
