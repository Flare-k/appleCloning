package apple.cloneApple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name="product")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    private String productid;        // 상품아이디

    private String productname;      // 상품명
    private Long productprice;       // 상품가격
    private String productcategory;  // 상품종류
    private String productdescription; // 상품설명
    private String productcompany;   // 제조회사
    private Integer productstock;        // 상품재고
    private String productcolor;     // 상품색상
    private Long productsize;        // 상품용량


    // Member 입장에서 Favorite은 OneToMany 관계
    // fetch? Member 조회 시 Favorite을 같이 가져올 것인가.
    // EAGER: 같이 가져옴, LAZY: Favorite을 사용할 때 가져옴
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Favorite> favorites = new ArrayList<>();

    @Builder
    public Product(String p_id, String p_name, Long p_price,
                   String p_category, String description,
                   String p_company, int p_stock,
                   String p_color, Long p_size){

        this.productid = p_id;
        this.productname = p_name;
        this.productprice = p_price;
        this.productcategory = p_category;
        this.productdescription = description;
        this.productcompany = p_company;
        this.productstock = p_stock;
        this.productcolor = p_color;
        this.productsize = p_size;

    }
}
