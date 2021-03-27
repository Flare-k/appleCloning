package apple.cloneApple.repository;

import apple.cloneApple.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    List<Favorite> findByUsername(String username);
    Favorite deleteByP_name(String p_name);
}
