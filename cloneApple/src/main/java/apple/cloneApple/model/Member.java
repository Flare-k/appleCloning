package apple.cloneApple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
아이디,이름, 성, 나이, 이메일, 연락처, 가입일, 탈퇴여부,
탈퇴일, 비회원여, 비밀번호
 */
@Entity
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long member_id;   // 아이디 1,2,3,4,...

    private String member_name; // 사용자 이름
    private String username; // 사용할 아이디
    private String password;    // 비밀번호
    private String email;   // 이메일
    private String phone;   // 전화번호
    private char gender;    // F, M
    private int age;        // 나이
    private LocalDate enroll_date;// 회원등록일
    private char del_flag; // 탈퇴 여부 0, 1
    private LocalDate delete_date;  //회원탈퇴일
    private Boolean enabled;      // 비회원 여부

    @JsonIgnore
    @ManyToMany
    @JoinTable( // 내가 만든 조인 테이블
            name = "user_role",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private List<Role> roles = new ArrayList<>();
}