package ua.com.kneu.course_admin_shop_np_2024.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery _delivery;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment _payment;

    private double valueOrder;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "addresse_id")
    private AddressClient addressClient;

    @ManyToOne
    private Clients cliente;

    @OneToMany(mappedBy = "_orderes")
    private List<ProductHasOrder> productHasOrderList;

}
