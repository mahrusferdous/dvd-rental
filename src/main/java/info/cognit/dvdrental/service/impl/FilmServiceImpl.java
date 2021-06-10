package info.cognit.dvdrental.service.impl;

import info.cognit.dvdrental.domain.entity.CustomerEntity;
import info.cognit.dvdrental.domain.entity.FilmEntity;
import info.cognit.dvdrental.domain.repository.CustomerRepo;
import info.cognit.dvdrental.domain.repository.FilmRepo;
import info.cognit.dvdrental.dto.FilmRequest;
import info.cognit.dvdrental.dto.Response;
import info.cognit.dvdrental.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<FilmEntity> getAllDVDs() {
        List<FilmEntity> dvds = new ArrayList<>();
        Iterable<FilmEntity> all = filmRepo.findAll();
        all.forEach(filmEntity -> dvds.add(filmEntity));
        return dvds;
    }

    @Override
    public FilmEntity getDVDById(Long id) {
        Optional<FilmEntity> byId = filmRepo.findById(id);
//        if(byId.isPresent()) {
            return byId.get();
//        }
    }

    @Override
    public List<FilmEntity> getAllFilmByTitleAndReleaseYear(String title, Integer releaseYear) {
        return filmRepo.findDVDByTitleAndReleaseYear(title, releaseYear);
    }

    @Override
    public Response<FilmEntity> addFilm(FilmRequest filmRequest) {
        CustomerEntity customer = customerRepo.findByFirstNameAndLastNameAndEmail(filmRequest.getCustomer().getFirstName(), filmRequest.getCustomer().getLastName(), filmRequest.getCustomer().getEmail());
        if (customer == null) {
            customer = customerRepo.save(buildNewCustomer(filmRequest.getCustomer()));
        }

        FilmEntity film = filmRepo.findFilmByTitle(buildNewFilm(filmRequest.getFilm().getTitle()));

        return null;
    }

    private String buildNewFilm(String title) {
        String newTitle = title.toUpperCase();
        return newTitle;
    }

    private CustomerEntity buildNewCustomer(CustomerEntity customer) {
        customer.setCreateDate(LocalDateTime.now());
        return customer;
    }
}
