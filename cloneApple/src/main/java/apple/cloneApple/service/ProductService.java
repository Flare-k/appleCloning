package apple.cloneApple.service;

import apple.cloneApple.model.Product;
import apple.cloneApple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findOne(String productName){
        return productRepository.findByProductname(productName);
    }

}
