package ua.com.kneu.course_admin_shop_np_2024.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.kneu.course_admin_shop_np_2024.entity.Clients;
import ua.com.kneu.course_admin_shop_np_2024.entity.Roles;
import ua.com.kneu.course_admin_shop_np_2024.entity.Users;
import ua.com.kneu.course_admin_shop_np_2024.repository.ClientsRepository;
import ua.com.kneu.course_admin_shop_np_2024.repository.UsersRepository;
import ua.com.kneu.course_admin_shop_np_2024.service.UserService;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UsersRepository usersRepository;
    private final ClientsRepository clientsRepository;

    @GetMapping("/login")
    public String getPageLogin(){
        return "login";
    }

    @GetMapping("/registration")
    public String getPageRegistration(Model model){

        model.addAttribute("users", new Users());
        model.addAttribute("clients", new Clients());

        return "registration";
    }

    @PostMapping("/registration")
    public String saveNewUser(@Valid Users users,
                              BindingResult bindingResult1,
                              @Valid Clients clients,
                              BindingResult bindingResult2
                              ){
        // Validation input user
        if(bindingResult1.hasErrors()){
            return "registration";
        }

        // Validation input client
        if(bindingResult2.hasErrors()){
            return "registration";
        }

        //  Перевірка на існування користувача в системі
        if(userService.getLogicUser(users.getUsername())) {
            return "registration";
        }


        users.setRolesset(Collections.singleton(new Roles(1L, "ROLE_User", "User")));
        Users user1 =  usersRepository.save(users);



        clients.setUser(user1);
        clientsRepository.save(clients);


        // шифрування пароля

        return "redirect:/login";
    }


}
