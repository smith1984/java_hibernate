package ru.smith.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.smith.model.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class ProductCategory extends Model {

    private static final long serialVersionUID = 5263527970062683709L;

    private String title;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "productCategory")
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "parentProductCategory")
    private ProductCategory parentProductCategory;
}
