package ua.com.kneu.course_admin_shop_np_2024.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String getHome(Model model){
        // model.addAttribute("text", "Hello Student");

        model.addAttribute("hello", "Hello Student!!");
        return "index3";
    }

    @GetMapping("/user")
    public String getUserPage(){
        return "user";
    }


    @GetMapping("/manager")
    public String getManagerPage(){
        return "manager";
    }


    @GetMapping("/admin")
    public String getAdminPage(){
        return "admin";
    }

    @GetMapping("/payment")
    public String getPagePayment(){
        return "payment";
    }

    @GetMapping("/delivery")
    public String getPageDelivery(){
        return "delivery";
    }



}
