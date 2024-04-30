package ua.com.kneu.course_admin_shop_np_2024.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kneu.course_admin_shop_np_2024.entity.Category;
import ua.com.kneu.course_admin_shop_np_2024.entity.Product;
import ua.com.kneu.course_admin_shop_np_2024.service.CategoryService;
import ua.com.kneu.course_admin_shop_np_2024.service.ProductService;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
public class AdminProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/product-manager")
    public String getProductManagerPage(Model model){

        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("categories", categoryService.findAllCategory());

        return "productAdmin";
    }


    @PostMapping("/saveNewProduct")
    public String saveNewProduct(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "link") String link,
                                 @RequestParam(name = "price") String price,
                                 @RequestParam(name = "category") Category category
                                 ){
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setImage(link);
        product.setPrice(new BigDecimal(Double.valueOf(price)));
        product.setCategorie(category);

        productService.save(product);

        return "redirect:/product-manager";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(
            @RequestParam(name = "id") Long id,
            @RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "image") String link,
                                 @RequestParam(name = "price") String price,
                                 @RequestParam(name = "category") Category category
    ){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        product.setImage(link);
        product.setPrice(new BigDecimal(Double.valueOf(price)));
        product.setCategorie(category);

        productService.update(product);

        return "redirect:/product-manager";
    }

    @PostMapping("/deleteProduct")
    public String updateProduct(
            @RequestParam(name = "id") Product product
    ){
        productService.delete(product);

        return "redirect:/product-manager";
    }



}
