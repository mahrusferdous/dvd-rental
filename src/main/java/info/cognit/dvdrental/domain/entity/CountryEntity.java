package info.cognit.dvdrental.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "country")
@Data
public class CountryEntity {
    @GeneratedValue(generator = "countryIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "countryIdGenerator", sequenceName = "country_country_id_seq", allocationSize = 1)
    @Id
    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "country")
    private String country;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
