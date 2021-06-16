package apple.cloneApple.controller;

import apple.cloneApple.dto.FavoriteDto;
import apple.cloneApple.model.Favorite;
import apple.cloneApple.model.Member;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.FavoriteRepository;
import apple.cloneApple.repository.ProductRepository;
import apple.cloneApple.service.FavoriteService;
import apple.cloneApple.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {

    private final MemberService memberService;
    private final FavoriteService favoriteService;
    private final ProductRepository productRepository;

    public FavoriteController(MemberService memberService, FavoriteService favoriteService, ProductRepository productRepository) {
        this.memberService = memberService;
        this.favoriteService = favoriteService;
        this.productRepository = productRepository;
    }

    // 즐겨찾기 조회
    @GetMapping("/view")
    public List<Favorite> getFavorite(Model model, Authentication authentication) {
        Member member = memberService.getMyUserWithAuthorities().get(); // 현재 로그인중인 username return

        List<Favorite> favorites = favoriteService.getFavorite(member.getMemId());

        return favorites;
    }
    
    // 즐겨찾기 추가 : 클라이언트에서 JSON 형태로 post 해줘야 함
    @PostMapping("/api")
    public ResponseEntity<Favorite> postFavorite(@Valid @RequestBody FavoriteDto favoriteDto) {
        Member member = memberService.getMyUserWithAuthorities().get(); // 현재 로그인중인 username return

        return ResponseEntity.ok(favoriteService.save(favoriteDto, member.getMemId()));
    }

/*
    @DeleteMapping("/favorite/{p_name}")
    public Favorite deleteFavorite(@PathVariable String p_name) {
        return favoriteRepository.deleteByName(p_name);
    }
*/
}