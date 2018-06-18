package ru.smith.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import ru.smith.model.Model;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
public class Product extends Model {

    private static final long serialVersionUID = -2728477341728566936L;

    private String nameProduct;

    private BigDecimal price;

    private String description;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "productCategoryId")
    private ProductCategory productCategory;


}
