package apple.cloneApple.service;

import apple.cloneApple.model.Member;
import apple.cloneApple.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private MemberService memberService;

    @Autowired
    private ProductService productService;

    public Product order(Member member, Product product){
        // member랑 product 조인
        long memberId = member.getMemPk();

        // 멤버 아이디에 맞는 장바구니 정보가 필요한데 ,,,,,
        // 장바구니 ........,, 에 제품을 어떻게 담죠 ........ ㅠㅠ

        return product;
    }
}
