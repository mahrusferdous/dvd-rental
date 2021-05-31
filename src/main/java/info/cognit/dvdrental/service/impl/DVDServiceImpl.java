package info.cognit.dvdrental.service.impl;

import javax.servlet.*;
import javax.servlet.http.*;

import info.cognit.dvdrental.domain.entity.DVDEntity;
import info.cognit.dvdrental.domain.repository.DVDRepo;
import info.cognit.dvdrental.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DVDServiceImpl implements DVDService {
    @Autowired
    private DVDRepo dvdRepo;

    @Override
    public List<DVDEntity> getAllDVDs() {
        List<DVDEntity> dvds = new ArrayList<>();
        Iterable<DVDEntity> all = dvdRepo.findAll();
        all.forEach(dvdEntity -> dvds.add(dvdEntity));
        return dvds;
    }

    @Override
    public DVDEntity getDVDById(long id) {
        Optional<DVDEntity> byId = dvdRepo.findById(id);
//        if(byId.isPresent()) {
            return byId.get();
//        }

    }

    @Override
    public DVDEntity getDVDbyTitleAndReleaseYear(String title, Integer releaseYear) {
        return dvdRepo.findDVDByTitleAndReleaseYear(title, releaseYear);
    }
}
