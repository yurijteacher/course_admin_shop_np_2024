package ua.com.kneu.course_admin_shop_np_2024.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product_has_order")
public class ProductHasOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product _product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order _orderes;

    private int quentity;

    public ProductHasOrder(Product _product,  int quentity, Order _orderes) {
        this._product = _product;
        this._orderes = _orderes;
        this.quentity = quentity;
    }
}
