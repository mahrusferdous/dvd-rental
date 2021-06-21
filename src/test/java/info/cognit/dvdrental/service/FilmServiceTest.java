package info.cognit.dvdrental.service;

import info.cognit.dvdrental.domain.entity.FilmEntity;
import info.cognit.dvdrental.domain.repository.FilmRepo;
import info.cognit.dvdrental.service.impl.FilmServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest extends BaseTest{
//    @Mock
//    private FilmRepo filmRepo;
//
//    @InjectMocks
//    private FilmService filmService = new FilmServiceImpl();
//
//    @Test
//    public void testGetFilmByTitle() {
//        Mockito.when(filmRepo.findFilmByTitle(Mockito.any())).thenReturn(getFilmEntityAsResponse());
//        FilmEntity response = filmService.getAllFilmByTitleAndReleaseYear(getFilmRequest().getFilm().getTitle(), getFilmRequest().getFilm().getReleaseYear());
//
//    }
}
