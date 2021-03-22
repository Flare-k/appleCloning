package apple.cloneApple.repository;

import apple.cloneApple.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    // List<Favorite> findByCategory(String category);
}
