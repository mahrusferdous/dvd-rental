package info.cognit.dvdrental.domain.repository;

import info.cognit.dvdrental.domain.entity.InventoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InventoryRepo extends CrudRepository<InventoryEntity, Long> {
    List<InventoryEntity> findByFilmId(Long filmId);
}
