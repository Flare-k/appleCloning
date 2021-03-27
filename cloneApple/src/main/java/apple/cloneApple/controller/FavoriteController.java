package apple.cloneApple.controller;

import apple.cloneApple.model.Favorite;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.FavoriteRepository;
import apple.cloneApple.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FavoriteController {
    // @Autowired
    // private FavoriteRepository favoriteRepository;

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private FavoriteRepository favoriteRepository;

    // 즐겨찾기 조회
    @GetMapping("/favorite")
    public String getFavorite(Model model, Authentication authentication) {

        String username = authentication.getName(); // 현재 로그인중인 username return

        List<Favorite> favorites = favoriteRepository.findByUsername(username);
        model.addAttribute("favorites", favorites);

        return "favorite";
    }

    @PostMapping("/favorite")
    public Favorite postFavorite(Product product, Authentication authentication) {
        // favorite table에 등록
        String username = authentication.getName();

        Favorite favorite = favoriteService.save(product, username);

        return favoriteRepository.save(favorite);
    }


    @DeleteMapping("/favorite/{p_name}")
    public Favorite deleteFavorite(@PathVariable String p_name) {
        return favoriteRepository.deleteByP_name(p_name);
    }

}
