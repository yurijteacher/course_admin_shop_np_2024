package ua.com.kneu.course_admin_shop_np_2024.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.kneu.course_admin_shop_np_2024.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String username); // SELECT * FROM `users` WHERE username = ?

    Users findByUsername(String username);


    @Transactional
    @Modifying
    @Query(value = "UPDATE `users` SET `password` = :password, `username` = :username WHERE `id` = :id", nativeQuery = true)
    void updateUserById(@Param("password") String password, @Param("username") String username, @Param("id") Long id);


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `users_rolesset` (`usersset_id`, `rolesset_id`) VALUES (:userId, :roleId);", nativeQuery = true)
    void updateRoleByUserId(@Param("userId") Long userId, @Param("roleId") Long roleId);

}
