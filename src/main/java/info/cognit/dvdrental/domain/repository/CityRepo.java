package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.CityEntity;
import org.springframework.data.repository.CrudRepository;

public interface CityRepo extends CrudRepository<CityEntity, Long> {
    CityEntity findByCity(String city);
}
