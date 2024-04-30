package ua.com.kneu.course_admin_shop_np_2024.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.kneu.course_admin_shop_np_2024.service.CategoryService;


@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category")
    public String getPageAllCategory(Model model,
                                     @PageableDefault(sort = {"id"},
                                     direction = Sort.Direction.ASC, size = 2)
                                     Pageable pageable

                                     ){

        model.addAttribute("page", categoryService.findPageCategory(pageable));
        model.addAttribute("url", "/category");

        return "category";
    }


}
