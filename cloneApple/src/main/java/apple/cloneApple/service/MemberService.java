package apple.cloneApple.service;

import apple.cloneApple.model.Member;
import apple.cloneApple.model.Role;
import apple.cloneApple.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;    //비밀번호 암호화

    public Member save(Member member) {

        // 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);

        // 회원등록일 설정
        LocalDate enroll_date;
        enroll_date = LocalDate.now();
        member.setEnroll_date(enroll_date);

        // 탈퇴한 회원인지 설정
        member.setDel_flag('0');

        // 탈퇴한 날짜 설정.. 회원가입 코드이므로 null로 설정
        LocalDate delete_date = null;
        member.setDelete_date(delete_date);

        // 비회원인지 설정
        member.setEnabled(true);

        Role role = new Role();
        role.setMember_id(1l);
        member.getRoles().add(role);  // role을 어떤 권한을 줄 것인지 저장한다. user_role 테이블에 role_id가 저장된다.

        return memberRepository.save(member);
    }

    public Member findOne(String username) {
        return memberRepository.findByUsername(username);
    }
}