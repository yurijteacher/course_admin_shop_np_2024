package ua.com.kneu.course_admin_shop_np_2024.bl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kneu.course_admin_shop_np_2024.entity.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class ItemCart {

    private Product product;
    private int quantity;

}
