package apple.cloneApple.controller;

import apple.cloneApple.dto.SignupDto;
import apple.cloneApple.model.Member;
import apple.cloneApple.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Member> signup(@Valid @RequestBody SignupDto signupDto) {
        return ResponseEntity.ok(memberService.signup(signupDto));
    }

    @GetMapping("/detail")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Member> getMyUserInfo() {
        return ResponseEntity.ok(memberService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/detail/{memId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Member> getUserInfo(@PathVariable String memId) {
        return ResponseEntity.ok(memberService.getUserWithAuthorities(memId).get());
    }

    // 장바구니
    @GetMapping("/order")
    void getMemberOrder(HttpSession session) {
        ResponseEntity.ok(memberService.getMyUserWithAuthorities());
        // return Product 예정 ...
    }
}