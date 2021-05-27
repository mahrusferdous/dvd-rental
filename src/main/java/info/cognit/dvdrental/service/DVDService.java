package info.cognit.dvdrental.service;

import info.cognit.dvdrental.domain.entity.DVDEntity;

import java.util.List;

public interface DVDService {
    List<DVDEntity> getAllDVDs();

    DVDEntity getDVDById();
}
