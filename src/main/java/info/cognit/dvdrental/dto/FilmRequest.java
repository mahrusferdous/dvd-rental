package info.cognit.dvdrental.dto;

import info.cognit.dvdrental.domain.entity.*;
import lombok.Data;

@Data
public class FilmRequest {
    private FilmEntity film;
    private CustomerEntity customer;
    private AddressEntity address;
    private CountryEntity country;
    private CityEntity city;
    private RentalEntity rental;
}
