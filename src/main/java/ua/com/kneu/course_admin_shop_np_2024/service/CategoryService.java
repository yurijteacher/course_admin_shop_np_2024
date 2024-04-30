package ua.com.kneu.course_admin_shop_np_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.kneu.course_admin_shop_np_2024.entity.Category;
import ua.com.kneu.course_admin_shop_np_2024.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService
{

    private final CategoryRepository categoryRepository;

    public void saveCategory(Category category){
        categoryRepository.save(category); // insert
    }

    public void updateCategory(Category category){
        categoryRepository.save(category); // update +id
    }

    public void  deleteCategory(Category category){
        categoryRepository.delete(category);
    }

    public List<Category> findAllCategory() {
      return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    public void deleteAllCategory(){
        categoryRepository.deleteAll();
    }

    public void saveCategories(List<Category> categories){
        for(Category el : categories){
            saveCategory(el);
        }
        // categoryRepository.saveAll(categories);
    }

    public Page<Category> findPageCategory(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }


}
