package apple.cloneApple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
public class Favorite {

    @Id
    private String p_id;        // 상품아이디
    private String p_name;      // 상품명
    private Integer amount;
    private Integer p_price;
    private Long member_id;

    @ManyToOne
    @JoinColumn(name="member_id")
    @JsonIgnore
    private Member member;
}