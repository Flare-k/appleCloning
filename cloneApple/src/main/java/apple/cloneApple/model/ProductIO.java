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
    /*
    CREATE TABLE `product_io` (
        `io_id`	varchar2	NOT NULL,
        `p_id`	varchar2(30)	NOT NULL,
        `order_no`	INT	NOT NULL,
        `amount`	INT	NULL,
        `status`	varchar2(10)	NULL,
        `io_date`	date	NULL,
        `member_id`	varchar2(15)	NOT NULL
    );
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String ioid; // io_id String으로 수정
    private String productid;
    private int orderno;
    private int amount;
    private String status;

    @CreationTimestamp
    private Timestamp iodate;
    private String member_id;

    @Builder
    public ProductIO(String io_id, String p_id, int order_no,
                     int amount, String status, Timestamp io_date,
                     String member_id){

        this.ioid = io_id;
        this.productid = p_id;
        this.orderno = order_no;
        this.amount = amount;
        this.status = status;
        this.iodate = io_date;
        this.member_id = member_id;
    }
}
