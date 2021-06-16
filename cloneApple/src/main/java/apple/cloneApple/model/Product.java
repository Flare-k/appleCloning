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
    @Column(name = "product_id")
    private String productId;        // 상품아이디

    @Column(name = "product_category")
    private String productCategory;  // 상품종류

    @Column(name = "product_name")
    private String productName;      // 상품명

    @Column(name = "product_price")
    private Long productPrice;       // 상품가격

    @Column(name = "description")
    private String description; // 상품설명

    @Column(name = "company")
    private String company;   // 제조회사

    @Column(name = "product_stock")
    private Integer productStock;        // 상품재고

    @Column(name = "product_color")
    private String productColor;     // 상품색상

    @Column(name = "product_size")
    private Long productSize;        // 상품용량


    // Member 입장에서 Favorite은 OneToMany 관계
    // fetch? Member 조회 시 Favorite을 같이 가져올 것인가.
    // EAGER: 같이 가져옴, LAZY: Favorite을 사용할 때 가져옴
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Favorite> favorites = new ArrayList<>();

    @Builder
    public Product(String productId,
                   String productName,
                   Long productPrice,
                   String productCategory,
                   String productDescription,
                   String productCompany,
                   int productStock,
                   String productColor,
                   Long productSize){

        this.productId          = productId;
        this.productName        = productName;
        this.productPrice       = productPrice;
        this.productCategory    = productCategory;
        this.description        = productDescription;
        this.company            = productCompany;
        this.productStock       = productStock;
        this.productColor       = productColor;
        this.productSize        = productSize;

    }
}
