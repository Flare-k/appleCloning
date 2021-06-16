package apple.cloneApple.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@ToString
@Entity
// @Table(name="product_io")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductIO {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "io_id")
    private String ioId;        // 입출고 id (pk)

    @Column(name = "order_id")
    private String orderId;     // 주문 id

    @Column(name = "mem_pk")
    private Long memPk;         // 회원 pk

    @Column(name = "status")
    private String status;      // 입출고 상태

    @CreationTimestamp
    @Column(name = "io_date")
    private Timestamp ioDate;   // 입출고 날짜

    @Builder
    public ProductIO(String io_id, String order_id, Long memPk,
                     String status, Timestamp io_date){

        this.ioId = io_id;
        this.orderId = order_id;
        this.memPk = memPk;
        this.status = status;
        this.ioDate = io_date;
    }
}
