package info.cognit.dvdrental.service;

import info.cognit.dvdrental.domain.entity.FilmEntity;
import info.cognit.dvdrental.dto.FilmRequest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BaseTest {
    public FilmEntity getFilmEntityAsResponse() {
        FilmEntity film = new FilmEntity();
        film.setFilmId(1L);
        film.setTitle("Great film");
        film.setDescription("This is something");
        film.setReleaseYear(2006);
        film.setLanguageId(1L);
        film.setRentalDuration(6);
        film.setRentalRate(2.99);
        return film;
    }

    public FilmRequest getFilmRequest() {
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setTitle("Great film");

        FilmRequest request = new FilmRequest();
        request.setFilm(filmEntity);
        return request;
    }
}
