package apple.cloneApple.controller;

import apple.cloneApple.model.Member;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.ProductRepository;
import apple.cloneApple.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/register")
    public String register() {
        return "member/register";
    }

    @PostMapping("/register")
    public String register(Member member) {
        memberService.save(member);
        return "redirect:/";
    }

    @GetMapping("/detail")
    public String memberDetail(HttpSession session, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Member member = memberService.findOne(auth.getName());
        model.addAttribute("member", member);

        //Logger logger = LoggerFactory.getLogger("MemberController.java");

        return "member/detail";
    }

    // 즐겨찾기 확인
    @GetMapping("/favorite")
    public String memberFavorite(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);

        return "member/favorite";
    }
}