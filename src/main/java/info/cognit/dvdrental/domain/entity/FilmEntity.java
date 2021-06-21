package info.cognit.dvdrental.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Long languageId;

    @Column(name = "RENTAL_DURATION")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;
}
