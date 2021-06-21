package info.cognit.dvdrental.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "RENTAL")
@Data
public class RentalEntity {
    @GeneratedValue(generator = "addressIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "addressIdGenerator", sequenceName = "address_address_id_seq", allocationSize = 1)
    @Id
    @Column(name = "RENTAL_ID")
    private Long rentalId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "RENTAL_DATE")
    private LocalDateTime rentalDate;

    @Column(name = "INVENTORY_ID")
    private Long inventoryId;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "RETURN_DATE")
    private LocalDateTime returnDate;

    @Column(name = "STAFF_ID")
    private Long staffId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
