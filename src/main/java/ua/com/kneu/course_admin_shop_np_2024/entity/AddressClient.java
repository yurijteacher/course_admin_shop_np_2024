package ua.com.kneu.course_admin_shop_np_2024.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(schema = "addressclient") // name
public class AddressClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private String city;
    private String street;
    private String builder;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Clients clientes;


}
