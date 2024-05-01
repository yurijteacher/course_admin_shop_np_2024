package ua.com.kneu.course_admin_shop_np_2024.entity;


/*
User No Reg
User Reg
Manager
Admin

*/

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority {

    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // NN AI
    private Long id;
    private String name;
    private String description;


    @ManyToMany(mappedBy = "rolesset")
    private Set<Users> usersset = new HashSet<>();

    public Roles(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
