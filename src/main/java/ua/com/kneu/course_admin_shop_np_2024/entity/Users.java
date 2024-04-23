package ua.com.kneu.course_admin_shop_np_2024.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50, message = "Кількість символів повинна бути в діапазоні від 2 до 50 символів")
    private String username;

    @Size(min = 2, message = "Кількість символів повинна бути в діапазоні від 2 до 50 символів")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> rolesset = new HashSet<>();

}
