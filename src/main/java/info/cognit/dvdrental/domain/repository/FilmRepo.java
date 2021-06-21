package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.FilmEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmRepo extends CrudRepository<FilmEntity, Long> {
    FilmEntity findFilmByTitle(String title);
    List<FilmEntity> findFilmByTitleAndReleaseYear(String title, Integer releaseYear);
}
