package apple.cloneApple.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@Table(name="order")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;
    private Long memId;
    private String orderNo;
    private String productId;
    private String resName;
    private String resAddr;
    private String resPhone;
    private String resMemo;
    private Integer totalPrice;
    private LocalDate orderDate;


    @Builder
    public OrderList(String orderId, Long memId, String orderNo, String productId, String resName, String resAddr, String resPhone, String resMemo, Integer totalPrice, LocalDate orderDate) {
        this.orderId = orderId;
        this.memId = memId;
        this.orderNo = orderNo;
        this.productId = productId;
        this.resName = resName;
        this.resAddr = resAddr;
        this.resPhone = resPhone;
        this.resMemo = resMemo;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
}
