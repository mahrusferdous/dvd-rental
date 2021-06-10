package info.cognit.dvdrental.service;

import info.cognit.dvdrental.domain.entity.FilmEntity;
import info.cognit.dvdrental.dto.FilmRequest;
import info.cognit.dvdrental.dto.Response;

import java.util.List;

public interface FilmService {

    List<FilmEntity> getAllDVDs();

    FilmEntity getDVDById(Long filmId);

    List<FilmEntity> getAllFilmByTitleAndReleaseYear(String title, Integer releaseYear);

    Response<FilmEntity> addFilm(FilmRequest filmRequest);
}
