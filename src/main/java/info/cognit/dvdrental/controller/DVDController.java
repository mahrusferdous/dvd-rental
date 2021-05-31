package info.cognit.dvdrental.controller;

import info.cognit.dvdrental.domain.entity.DVDEntity;
import info.cognit.dvdrental.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/dvdrental")
public class DVDController {
    @Autowired
    private DVDService dvdService;

    @GetMapping("/all")
    public List<DVDEntity> getAll() {
        return dvdService.getAllDVDs();
    }

    @GetMapping(value = "/all", params = {"filmId"})
    public DVDEntity getOneDVDByFilmId(@RequestParam("filmId") long filmId) {
        return dvdService.getDVDById(filmId);
    }

    @GetMapping(value = "/all", params = {"title", "releaseYear"})
    public DVDEntity getDVDByTitleAndReleaseYear(@RequestParam("title") String title, @RequestParam("releaseYear") Integer releaseYear) {
        return dvdService.getDVDbyTitleAndReleaseYear(title, releaseYear);
    }

}
