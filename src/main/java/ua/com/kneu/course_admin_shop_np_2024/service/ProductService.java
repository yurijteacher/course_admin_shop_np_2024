package ua.com.kneu.course_admin_shop_np_2024.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.kneu.course_admin_shop_np_2024.entity.Product;
import ua.com.kneu.course_admin_shop_np_2024.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

/*    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }*/

    public void save(Product product){
        productRepository.save(product);
    }

    public void update(Product product){
        productRepository.save(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> findProductById(Long id){
        return productRepository.findById(id);
    }

    public void deleteAllProduct(){
        productRepository.deleteAll();
    }



}
