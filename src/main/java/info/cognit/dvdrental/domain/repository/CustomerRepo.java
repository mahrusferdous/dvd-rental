package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepo extends CrudRepository<CustomerEntity, Long> {
    CustomerEntity findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);
}
