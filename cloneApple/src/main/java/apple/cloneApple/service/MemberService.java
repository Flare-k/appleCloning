package apple.cloneApple.service;

import apple.cloneApple.dto.SignupDto;
import apple.cloneApple.model.Authority;
import apple.cloneApple.model.Member;
import apple.cloneApple.repository.MemberRepository;
import apple.cloneApple.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Member signup(SignupDto signupDto) {
        if (memberRepository.findOneWithAuthoritiesByMemId(signupDto.getMemId()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        //빌더 패턴의 장점
        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        // 아이디, 비밀번호, 이름, 성별, 나이, 이메일, 전화번호, 주소, 등록일, 탈퇴여부, 탈퇴일
        Member member = Member.builder()
                .memId(signupDto.getMemId())
                .memPassword(passwordEncoder.encode(signupDto.getMemPassword()))
                .memName(signupDto.getMemName())
                .memGender(signupDto.getMemGender())
                .memAge(signupDto.getMemAge())
                .memEmail(signupDto.getMemEmail())
                .memPhone(signupDto.getMemPhone())
                .memAddr(signupDto.getMemAddr())
                .enrollDate(LocalDate.now())
                .delFlag(false)
                .authorities(Collections.singleton(authority))
                .regFlag(true)
                .build();

        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Optional<Member> getUserWithAuthorities(String memId) {
        return memberRepository.findOneWithAuthoritiesByMemId(memId);
    }

    @Transactional(readOnly = true)
    public Optional<Member> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(memberRepository::findOneWithAuthoritiesByMemId);
    }

}