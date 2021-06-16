package apple.cloneApple.service;

import apple.cloneApple.dto.FavoriteDto;
import apple.cloneApple.model.Favorite;
import apple.cloneApple.repository.FavoriteRepository;
import apple.cloneApple.repository.ProductRepository;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final ProductRepository productRepository;

    public FavoriteService(FavoriteRepository favoriteRepository, ProductRepository productRepository) {
        this.favoriteRepository = favoriteRepository;
        this.productRepository = productRepository;
    }

    // 즐겨찾기 등록 - 클라이언트에서 JSON으로 post 해주면 favoriteDto 형태로 가져와 DB에 저장
    @Transactional
    public Favorite save(FavoriteDto favoriteDto, String memId) {
        if (favoriteRepository.findByProductIdAndMemId(favoriteDto.getProductId(), memId).orElse(null) != null) {
            throw new RuntimeException("이미 등록되어 있는 제품입니다.");
        }

        Favorite favorite = Favorite.builder()
                .productId(favoriteDto.getProductId())
                .amount(favoriteDto.getAmount())
                .memId(memId)
                .build();


        return favoriteRepository.save(favorite);
    }
    
    // 즐겨찾기 조회 - 회원 아이디를 기준으로 즐겨찾기 조회
    @Transactional(readOnly = true)
    public List<Favorite> getFavorite(String memId) {
        return favoriteRepository.findByMemId(memId);
    }
}
