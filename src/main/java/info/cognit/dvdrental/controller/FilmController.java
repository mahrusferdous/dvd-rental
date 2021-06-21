package info.cognit.dvdrental.controller;

import info.cognit.dvdrental.domain.entity.FilmEntity;
import info.cognit.dvdrental.dto.FilmRequest;
import info.cognit.dvdrental.dto.Response;
import info.cognit.dvdrental.dto.ResponseStatus;
import info.cognit.dvdrental.service.FilmService;
import info.cognit.dvdrental.validator.FilmValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Autowired
    private FilmValidator filmValidator;

    @GetMapping("/all")
    public List<FilmEntity> getAll() {
        return filmService.getAllFilms();
    }

    @GetMapping(value = "/{filmId}")
    public FilmEntity getOneDVDByFilmId(@PathVariable Long filmId) {
        return filmService.getFilmById(filmId);
    }

    @GetMapping(value = "/all", params = {"title", "releaseYear"})
    public ResponseEntity<Response> getDVDByTitleAndReleaseYear(@RequestParam("title") String title, @RequestParam("releaseYear") Integer releaseYear) {
        ResponseEntity<Response> responseEntity = filmValidator.validateGetFilmByTitleAndReleaseYear(title, releaseYear);

        if(responseEntity.getBody().getStatus() == ResponseStatus.ERROR) {
            return responseEntity;
        }

        List<FilmEntity> film = filmService.getAllFilmByTitleAndReleaseYear(title, releaseYear);
        Response<List<FilmEntity>> response = new Response<>();
        response.setBody(film);
        response.setStatus(ResponseStatus.SUCCESS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public ResponseEntity<Response> add(@RequestBody FilmRequest filmRequest) {
//        Response<FilmEntity> response = filmValidator.validateRequiredFields(filmRequest);
//        if (response.getStatus() == ResponseStatus.ERROR) {
//            response = filmService.addFilm(filmRequest);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

    @PostMapping("/add")
    public ResponseEntity<Response> add(@RequestBody FilmRequest filmRequest) {
        Response<FilmEntity> response = filmService.addFilm(filmRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
