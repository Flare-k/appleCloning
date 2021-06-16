package apple.cloneApple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "favorite")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {

    @Id
    @Column(name = "favorite_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Long favoritePk;

    @Column(name = "product_id")
    private String productId;          // 제품 아이디

    @Column(name = "amount")
    private Integer amount;     // 수량

    @Column(name = "mem_id")
    private String memId;     // 회원 Login 아이디(테이블 상 아이디)

    @ManyToOne
    @JoinColumn(name="product_id", insertable=false, updatable=false)
    @JsonIgnore
    private Product product;
}
