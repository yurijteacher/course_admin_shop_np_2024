package ua.com.kneu.course_admin_shop_np_2024.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private int phone;
    private int age;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private Users user;

    @OneToMany(mappedBy = "clientes")
    private List<AddressClient> clientList;

    @OneToMany(mappedBy = "cliente")
    private List<Order> orders;
}
