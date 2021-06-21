package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.RentalEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RentalRepo extends CrudRepository<RentalEntity, Long> {
    List<RentalEntity> findByInventoryId(Long inventoryId);
}
