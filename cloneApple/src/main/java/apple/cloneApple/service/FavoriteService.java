package apple.cloneApple.service;

import apple.cloneApple.model.Favorite;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class FavoriteService {

    @Autowired
    private MemberRepository memberRepository;

    @ResponseBody
    public Favorite save(Product product, String username) {
        Favorite favorite = new Favorite();

        favorite.setProductid(product.getProductid());
        favorite.setProductname(product.getProductname());
        favorite.setAmount(product.getProductstock());
        favorite.setProductprice(product.getProductprice());
        favorite.setUsername(username);

        return favorite;
    }
}
