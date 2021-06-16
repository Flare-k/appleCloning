package apple.cloneApple.repository;

import apple.cloneApple.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    List<Favorite> findByMemId(String memId);
    Optional<Favorite> findByProductIdAndMemId(String productId, String memId); // 즐겨찾기에 이미 있는 제품인지 조회. 상품ID, 회원ID로 조회
    //Favorite deleteByName(String p_name);
}
