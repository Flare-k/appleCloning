package apple.cloneApple.controller;

import apple.cloneApple.model.Member;
import apple.cloneApple.model.Product;
import apple.cloneApple.repository.ProductRepository;
import apple.cloneApple.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller // 뷰페이지와 연결할 때 사용
@RestController // 문자열, VO 객체, 자바 컬렉션 등을 뷰페이지 없이 바로 JSON로 변환해 제공
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ProductRepository productRepository;

    // login 화면
    @GetMapping("/login")
    public String getLogin() {
        return "member/login";
    }

    // 회원가입 화면
    @GetMapping("/register")
    public String getRegister() {
        return "member/register";
    }

    // 회원가입 POST
    @PostMapping("/register")
    public String postRegister(Member member) {
        memberService.save(member);
        return "redirect:/";
    }

    // 상세 유저 페이지
    @GetMapping("/detail")
    Member getMemberDetail(HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Member member = memberService.findOne(auth.getName());
        // model.addAttribute("member", member);

        return memberService.findOne(auth.getName());
    }

    // 장바구니
    @GetMapping("/order")
    void getMemberOrder(HttpSession session) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Member member = memberService.findOne(auth.getName());
        // return Product 예정 ...
    }
}