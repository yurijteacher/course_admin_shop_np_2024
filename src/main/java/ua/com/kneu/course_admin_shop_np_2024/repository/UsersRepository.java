package ua.com.kneu.course_admin_shop_np_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.course_admin_shop_np_2024.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String username);

    Users findByUsername(String username);
}
