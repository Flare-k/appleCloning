package apple.cloneApple.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {

   // 아이디, 비밀번호, 이름, 성별, 나이, 이메일, 전화번호, 주소

    @NotNull
    @Size(min = 3, max = 50)
    private String memId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @Size(min = 3, max = 100)
    private String memPassword;

    @NotNull
    @Size(min = 3, max = 50)
    private String memName;

    @NotNull
    private String memGender;

    @NotNull
    private Integer memAge;

    @NotNull
    @Size(min = 3, max = 50)
    private String memEmail;

    @NotNull
    @Size(min = 3, max = 13)
    private String memPhone;

    @NotNull
    @Size(min = 3, max = 200)
    private String memAddr;

}
