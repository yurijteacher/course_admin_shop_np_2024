package ua.com.kneu.course_admin_shop_np_2024.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.course_admin_shop_np_2024.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
