package ua.com.kneu.course_admin_shop_np_2024.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.course_admin_shop_np_2024.entity.Category;
import ua.com.kneu.course_admin_shop_np_2024.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByCategorie(Category category);
//    List<Product> findAllByCategoriesAndAndBrandes(Category category, Brande brande);


    // пошук по словам!!!
    List<Product> findAllByNameOrderByName(String name);

    // пошук по буквам!!!
    List<Product> findAllByNameContainsIgnoreCaseOrderByName(String name);
    Page<Product> findAllByCategorie(Pageable pageable, Category category);

}
