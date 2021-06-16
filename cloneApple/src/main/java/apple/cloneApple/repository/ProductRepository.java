package apple.cloneApple.repository;

import apple.cloneApple.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByProductCategory(String productCategory);
    Product findByProductId(String productId);
    Product findByProductName(String productName);
}
