package apple.cloneApple.controller;

import apple.cloneApple.model.Product;
import apple.cloneApple.repository.ProductRepository;
import apple.cloneApple.service.ProductService;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value="/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private ProductRepository productRepository;
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

/*    @GetMapping("/{category}")
    public String getMain(Model model, @PathVariable String category) {
        List<Product> products = productRepository.findByProductcategory(category);
        model.addAttribute("products", products);

        return "product/{categoty}";
    }*/

    /* category */
    @GetMapping("/{product}")
    public Product getProduct(@PathVariable String product) {

        String[] str = product.split("-");
        String product_type = str[0];
        System.out.println(product_type);
        if (product_type.equals("macbook") || product_type.equals("imac")) {
            product_type = "mac";
        }

        Product productOper = productService.findOne(product);
        return productOper;
    }
}
