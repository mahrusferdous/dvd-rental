package info.cognit.dvdrental.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @Column(name = "inventory_id")
    private Long inventoryId;

    @Column(name = "film_id")
    private Long filmId;

    @Column(name = "store_id")
    private Long storeId;
}
