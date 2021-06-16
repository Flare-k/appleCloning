package apple.cloneApple.controller;

import apple.cloneApple.model.Product;
import apple.cloneApple.repository.ProductRepository;
import apple.cloneApple.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping(value="/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private ProductRepository productRepository;
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    /* category */
    @GetMapping("/{product}")
    public Product getProduct(@PathVariable String product) {

        String[] str = product.split("-");
        String productType = str[0];
        System.out.println(productType);
        if (productType.equals("macbook") || productType.equals("imac")) {
            productType = "mac";
        }

        Product productOper = productService.findOne(product);
        return productOper;
    }
}
