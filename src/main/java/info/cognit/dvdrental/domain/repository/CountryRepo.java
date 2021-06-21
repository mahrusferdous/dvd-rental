package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<CountryEntity, Long> {
    CountryEntity findByCountry(String country);
}
