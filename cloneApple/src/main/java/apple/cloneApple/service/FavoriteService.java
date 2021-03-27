package apple.cloneApple.service;

import apple.cloneApple.model.Favorite;
import apple.cloneApple.model.Member;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {

    @Autowired
    private MemberRepository memberRepository;

    public Favorite save(Product product, String username) {
        Favorite favorite = new Favorite();

        favorite.setP_id(product.getP_id());
        favorite.setP_name(product.getP_name());
        favorite.setAmount(product.getP_stock());
        favorite.setP_price(product.getP_price());
        favorite.setUsername(username);

        return favorite;
    }
}
