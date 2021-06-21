package info.cognit.dvdrental.domain.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "city")
@Data
public class CityEntity {
    @GeneratedValue(generator = "cityIdGenerator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cityIdGenerator", sequenceName = "city_city_id_seq", allocationSize = 1)
    @Id
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city")
    private String city;

    @Column(name = "country_id")
    private Long countryId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;
}
