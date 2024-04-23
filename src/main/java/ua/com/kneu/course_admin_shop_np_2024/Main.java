package ua.com.kneu.course_admin_shop_np_2024;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.com.kneu.course_admin_shop_np_2024.entity.Roles;
import ua.com.kneu.course_admin_shop_np_2024.repository.RolesRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class Main {

    private final RolesRepository rolesRepository;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


    @Bean
    CommandLineRunner run(){

        return args -> {

            if(rolesRepository.findAll().isEmpty()){
                rolesRepository.save(new Roles(1L, "ROLE_User", "User"));
                rolesRepository.save(new Roles(2L, "ROLE_Manager", "Manager"));
                rolesRepository.save(new Roles(3L, "ROLE_Admin", "Admin"));
            }
        };

    }
}
