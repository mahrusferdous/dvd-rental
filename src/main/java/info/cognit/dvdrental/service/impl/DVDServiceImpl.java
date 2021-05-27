package info.cognit.dvdrental.service.impl;

import info.cognit.dvdrental.domain.entity.DVDEntity;
import info.cognit.dvdrental.domain.repository.DVDRepo;
import info.cognit.dvdrental.service.DVDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public DVDEntity getDVDById() {
        return null;
    }
}
