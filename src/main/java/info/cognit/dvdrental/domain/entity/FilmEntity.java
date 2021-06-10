package info.cognit.dvdrental.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "FILM")
@Data
public class FilmEntity {
    @Id
    @Column(name = "FILM_ID")
    private Long filmId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RELEASE_YEAR")
    private Integer releaseYear;

    @Column(name = "LANGUAGE_ID")
    private Integer languageId;

    @Column(name = "RENTAL_DURATION")
    private Integer rentalDuration;

    @Column(name = "LAST_UPDATE")
    private LocalDateTime lastUpdate;
}
