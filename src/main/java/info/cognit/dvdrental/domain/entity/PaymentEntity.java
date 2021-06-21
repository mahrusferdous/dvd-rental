package info.cognit.dvdrental.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENT")
@Data
public class PaymentEntity {
    @GeneratedValue(generator = "paymentIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "paymentIdGenerator", sequenceName = "payment_payment_id_seq", allocationSize = 1)
    @Id
    @Column(name = "PAYMENT_ID")
    private Long paymentId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "STAFF_ID")
    private Long staffId;

    @Column(name = "RENTAL_ID")
    private Long rentalId;

    @Column(name = "AMOUNT")
    private Double amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;
}
