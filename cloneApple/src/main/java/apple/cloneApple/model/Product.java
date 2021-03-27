package apple.cloneApple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Product {

    @Id
    private String p_id;        // 상품아이디
    private String p_name;      // 상품명
    private Long p_price;       // 상품가격
    private String category;  // 상품종류
    private String description; // 상품설명
    private String p_company;   // 제조회사
    private int p_stock;        // 상품재고
    private String p_color;     // 상품색상
    private Long p_size;        // 상품용량


    // Member 입장에서 Favorite은 OneToMany 관계
    // fetch? Member 조회 시 Favorite을 같이 가져올 것인가.
    // EAGER: 같이 가져옴, LAZY: Favorite을 사용할 때 가져옴
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Favorite> favorites = new ArrayList<>();

}