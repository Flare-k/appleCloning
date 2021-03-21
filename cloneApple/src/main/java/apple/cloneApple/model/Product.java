package apple.cloneApple.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

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

}