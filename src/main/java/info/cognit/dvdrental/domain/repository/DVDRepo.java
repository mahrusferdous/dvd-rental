package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.DVDEntity;
import org.springframework.data.repository.CrudRepository;

public interface DVDRepo extends CrudRepository<DVDEntity, Long> {
}
