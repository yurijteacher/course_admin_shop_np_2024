package ua.com.kneu.course_admin_shop_np_2024.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.kneu.course_admin_shop_np_2024.entity.Category;
import ua.com.kneu.course_admin_shop_np_2024.service.CategoryService;
import ua.com.kneu.course_admin_shop_np_2024.service.SaveCategoryToDBFromExcel;
import ua.com.kneu.course_admin_shop_np_2024.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AdminCategoryController {

    private final CategoryService categoryService;
    private final SaveCategoryToDBFromExcel saveCategoryToDBFromExcel;

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

    @PostMapping("saveFromExcel")
    public String saveCategoryToDbFromExcel(@RequestParam("file") MultipartFile file){

        List<Category> categories = new ArrayList<>();

        String path = "/Users/urijlozovik/Desktop/" + file.getOriginalFilename();

        if(file !=null && !file.getOriginalFilename().isEmpty()) {

            Valid valid = new Valid();
            if (valid.logicXLS(file.getOriginalFilename())) {
                categories = saveCategoryToDBFromExcel.saveListCategoryToDbFromExcel(path);
                categoryService.saveCategories(categories);
            } else if (valid.logicXLSX(file.getOriginalFilename())) {
                categories = saveCategoryToDBFromExcel.saveListCategoryToDbFromExcel2(path);
                categoryService.saveCategories(categories);
            }
        }
        return "redirect:/category-admin";
    }

}
