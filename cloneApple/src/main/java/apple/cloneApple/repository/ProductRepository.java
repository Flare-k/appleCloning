package apple.cloneApple.repository;

import apple.cloneApple.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByProductcategory(String category);
    Product findByProductid(String productid);
    Product findByProductname(String productname);
}
