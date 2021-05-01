package apple.cloneApple.controller;

import apple.cloneApple.model.Favorite;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.FavoriteRepository;
import apple.cloneApple.repository.ProductRepository;
import apple.cloneApple.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableWebSecurity
@Controller
@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private ProductRepository productRepository;


    // 즐겨찾기 조회
    @GetMapping("/view")
    public List<Favorite> getFavorite(Model model, Authentication authentication) {

        String username = authentication.getName(); // 현재 로그인중인 username return

        List<Favorite> favorites = favoriteRepository.findByUsername(username);
        model.addAttribute("favorites", favorites);

        return favorites;
    }

    @ResponseBody
    @PostMapping("/api")
    public Favorite postFavorite(@RequestParam(required = false)  String productid, Authentication authentication) {


        // favorite table에 등록
        String username = authentication.getName();

        Product product = productRepository.findByProductid(productid);

        Favorite favorite = favoriteService.save(product, username);
        favoriteRepository.save(favorite);

        return favorite;
    }

/*
    @DeleteMapping("/favorite/{p_name}")
    public Favorite deleteFavorite(@PathVariable String p_name) {
        return favoriteRepository.deleteByName(p_name);
    }
*/
}