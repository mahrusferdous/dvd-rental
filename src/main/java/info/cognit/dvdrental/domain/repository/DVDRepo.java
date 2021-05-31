package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.DVDEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DVDRepo extends CrudRepository<DVDEntity, Long> {

    DVDEntity findDVDByTitleAndReleaseYear(String title, Integer releaseYear);
}
