package apple.cloneApple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/*
아이디,이름, 성, 나이, 이메일, 연락처, 가입일, 탈퇴여부,
탈퇴일, 비회원여부, 비밀번호
 */
@Entity
@Table(name = "member")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "mem_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long memPk;     // Primary Key

    @Column(name = "mem_id")
    private String memId;           // 사용할 아이디

    @Column(name = "mem_name")
    private String memName;         // 사용자 이름

    @Column(name = "mem_gender")
    private String memGender;       // F, M

    @Column(name = "mem_age")
    private Integer memAge;         // 나이

    @Column(name = "mem_email")
    private String memEmail;        // 이메일

    @Column(name = "mem_phone")
    private String memPhone;        // 전화번호

    @Column(name = "mem_addr")
    private String memAddr;

    @JsonIgnore
    @Column(name = "mem_password")
    private String memPassword;     // 비밀번호

    @Column(name = "enroll_date")
    private LocalDate enrollDate;   // 회원등록일

    @Column(name = "del_flag")
    private Boolean delFlag;      // 탈퇴 여부 0, 1

    @Column(name = "del_date")
    private LocalDate delDate;      //회원탈퇴일

    @JsonIgnore
    @Column(name = "reg_flag")
    private Boolean regFlag;        // 비회원 여부

    @ManyToMany
    @JoinTable (
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "mem_pk", referencedColumnName = "mem_pk")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})

    private Set<Authority> authorities;


}