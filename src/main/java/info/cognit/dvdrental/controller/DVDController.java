package info.cognit.dvdrental.controller;

import info.cognit.dvdrental.domain.entity.DVDEntity;
import info.cognit.dvdrental.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
