package info.cognit.dvdrental.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ADDRESS")
@Data
public class AddressEntity {
    @GeneratedValue(generator = "addressIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "addressIdGenerator", sequenceName = "address_address_id_seq", allocationSize = 1)
    @Id
    @Column(name = "ADDRESS_ID")
    private Long addressId;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DISTRICT")
    private String district;

    @Column(name = "CITY_ID")
    private Long cityId;

    @Column(name = "PHONE")
    private Integer phone;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
