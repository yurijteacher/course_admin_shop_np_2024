package ua.com.kneu.course_admin_shop_np_2024.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ua.com.kneu.course_admin_shop_np_2024.service.UserService;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(passwordEncoder());
        authProvider.setUserDetailsService(userService);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((authorize)->
                        authorize
                                .requestMatchers("/","/delivery","/payment","/category","/registration", "/registration/**",
                                        "/delivery","/payment", "/order", "/thank","/cart","/category/*","/addToCart",
                                        "/updateItemInCart","/deleteItemFromCart","/deleteAllItem", "/static/**"
                                        )
                                .permitAll()
                                .requestMatchers("/user","/order","/buy")
                                .hasRole("User")
                                .requestMatchers("/manager",
                                        "/saveNewCategory","/category-admin","/deleteCategory","/deleteAllCategory"
                                        ,"/product-manager", "/saveNewProduct", "/updateProduct", "/deleteProduct", "/saveFromExcel",
                                        "/upload"
                                )
                                .hasRole("Manager")
                                .requestMatchers("/admin", "/admin-users","/update-users","/update-roles-users")
                                .hasRole("Admin")
                                .anyRequest()
                                .authenticated()
                )
                .formLogin((form)-> form
                                .loginPage("/login")
                                .defaultSuccessUrl("/")
                                .permitAll()

                )
                .logout((logout)->logout.permitAll().logoutSuccessUrl("/"))
                .authenticationProvider(authenticationProvider());

        return http.build();
    }

}
