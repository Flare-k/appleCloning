package apple.cloneApple.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto {

    @NotNull
    private String productId;          // 제품 아이디

    @NotNull
    private Integer amount;     // 수량
}
