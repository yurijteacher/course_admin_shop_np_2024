package ua.com.kneu.course_admin_shop_np_2024.config;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kneu.course_admin_shop_np_2024.entity.Category;
import ua.com.kneu.course_admin_shop_np_2024.service.CategoryService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category-admin")
    public String getCategoryPage(Model model){

            List<Category> categories = categoryService.findAllCategory();
            model.addAttribute("categories", categories);

        return "categoryAdmin";
    }

    @PostMapping("/saveNewCategory")
    public String saveNewCategory(@RequestParam(name = "name") String name,
                                  @RequestParam(name = "description") String description,
                                  @RequestParam(name = "image") String image
                                  ){


        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setImage(image);

        categoryService.saveCategory(category);

        return "redirect:/category-admin";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "description") String description,
                                 @RequestParam(name = "image") String image,
                                 @RequestParam(name = "id") Category category
                                 ){

        category.setImage(image);
        category.setName(name);
        category.setDescription(description);

        categoryService.updateCategory(category);

        return "redirect:/category-admin";
    }


    @PostMapping("/deleteCategory")
    public String deleteCategory(@RequestParam(name = "id") Category category){

        categoryService.deleteCategory(category);

        return "redirect:/category-admin";
    }

    @PostMapping("/deleteAllCategory")
    public String deleteAllCategory(){

        categoryService.deleteAllCategory();

        return "redirect:/category-admin";
    }

}
