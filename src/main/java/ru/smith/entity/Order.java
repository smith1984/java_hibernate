package ru.smith.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.smith.model.Model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordered")
@Data
@NoArgsConstructor
public class Order extends Model {

    private static final long serialVersionUID = -5000573878157079593L;
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId")
    private Product product;

    private BigDecimal price;

    private boolean status;

    private int count;
}
