package apple.cloneApple.service;

import apple.cloneApple.controller.RestException;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findOne(String productName){
        Product product = productRepository.findByProductname(productName);

        Optional.of(product).orElseThrow(() ->
                new RestException(HttpStatus.NOT_FOUND, "Not found product"));

        return product;
    }

}
