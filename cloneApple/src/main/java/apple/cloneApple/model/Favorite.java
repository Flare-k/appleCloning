package apple.cloneApple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Favorite {

    @Id
    private String productid;          // 제품 아이디

    private String productname;      // 제품명
    private Integer amount;     // 수량
    private Long productprice;    // 가격
    private String username;     // 회원 Login 아이디(테이블 상 아이디)

    @ManyToOne
    @JoinColumn(name="productid", insertable=false, updatable=false)
    @JsonIgnore
    private Product product;
}
