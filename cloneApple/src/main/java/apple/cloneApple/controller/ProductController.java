package apple.cloneApple.controller;

import apple.cloneApple.model.Product;
import apple.cloneApple.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "product/list";
    }

    @GetMapping("/list/{category}")
    public String categoryList(Model model, @PathVariable String category) {
        List<Product> products = productRepository.findByCategory(category);
        model.addAttribute("products", products);

        return "product/list";
    }


}