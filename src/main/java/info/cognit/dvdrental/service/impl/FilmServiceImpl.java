package info.cognit.dvdrental.service.impl;

import info.cognit.dvdrental.domain.entity.*;
import info.cognit.dvdrental.domain.repository.*;
import info.cognit.dvdrental.dto.FilmRequest;
import info.cognit.dvdrental.dto.Response;
import info.cognit.dvdrental.dto.ResponseStatus;
import info.cognit.dvdrental.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private RentalRepo rentalRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CityRepo cityRepo;

    @Override
    public List<FilmEntity> getAllFilms() {
        List<FilmEntity> films = new ArrayList<>();
        Iterable<FilmEntity> all = filmRepo.findAll();
        all.forEach(filmEntity -> films.add(filmEntity));
        return films;
    }

    @Override
    public FilmEntity getAllFilmByTitle(String title) {
        return filmRepo.findFilmByTitle(title);
    }

    @Override
    public FilmEntity getFilmById(Long id) {
        Optional<FilmEntity> byId = filmRepo.findById(id);
//        if(byId.isPresent()) {
            return byId.get();
//        }
    }

    @Override
    public Response<FilmEntity> addFilm(FilmRequest filmRequest) {
        Response response = new Response();
        // Search by title of film
        FilmEntity film = filmRepo.findFilmByTitle(buildFilmUpper(filmRequest.getFilm().getTitle()));

        // Search by firstName lastName and email
        CustomerEntity customer = customerRepo.findByFirstNameAndLastNameAndEmail(filmRequest.getCustomer().getFirstName(), filmRequest.getCustomer().getLastName(), filmRequest.getCustomer().getEmail());
        if (customer == null) {
            //Country
            CountryEntity country = countryRepo.findByCountry(filmRequest.getCountry().getCountry());
            if (country == null) {
                country = countryRepo.save(buildCountryDate(filmRequest.getCountry()));
            }

            //City
            CityEntity city = cityRepo.findByCity(filmRequest.getCity().getCity());
            if (city == null) {
                city = cityRepo.save(buildNewCity(filmRequest.getCity(), country.getCountryId()));
            }

            AddressEntity address = addressRepo.save(buildNewAddress(filmRequest.getAddress(), city.getCityId()));
            customer = customerRepo.save(buildNewCustomer(filmRequest.getCustomer(), address.getAddressId()));

            response.setMessage("Customer has been created.");
        } else {
            response.setMessage("Customer exists in our system");
            response.setStatus(ResponseStatus.SUCCESS);
        }

        // Finding all available inventory
        List<InventoryEntity> inventory = inventoryRepo.findByFilmId(film.getFilmId());
        List<Long> inventoryId = new ArrayList<>();
        for(InventoryEntity checkInventory : inventory) {
            inventoryId.add(checkInventory.getInventoryId());
        }

        RentalEntity rental = rentalSearching(inventoryId);
        if (rental == null) {
            response.setMessage("Film is not available for renting");
        } else {
            PaymentEntity payment = paymentRepo.save(buildNewPayment(rental.getRentalId(), film.getRentalRate(), customer.getCustomerId()));
            response.setBody(payment);
        }

//        response.setBody(rental);
        return response;
    }

    private PaymentEntity buildNewPayment(Long rentalId, Double rentalRate, Long customerId) {
        Long staffId = new Long(2);
        PaymentEntity payment = new PaymentEntity();
        payment.setCustomerId(customerId);
        payment.setRentalId(rentalId);
        payment.setAmount(rentalRate);
        payment.setStaffId(staffId);
        payment.setPaymentDate(LocalDateTime.of(2020, 6, 10, 5, 30, 10));
        return payment;
    }

    private RentalEntity rentalSearching(List<Long> inventoryId) {
        for(Long iId : inventoryId) {
            List<RentalEntity> rental = rentalRepo.findByInventoryId(iId);
            if (rental.size()-1 != -1) {
                RentalEntity singleRental = rental.get(rental.size()-1);
                if (singleRental.getReturnDate() == null) {
                    RentalEntity mainRental = rentalRepo.save(buildNewRental(singleRental));
                    return mainRental;
                }
            }
        }
        return null;
    }

    private RentalEntity buildNewRental(RentalEntity rental) {
        rental.getRentalDate();
        rental.getInventoryId();
        rental.setReturnDate(LocalDateTime.now().plusDays(7));
        rental.getStaffId();
        rental.setLastUpdate(LocalDateTime.now());
        return rental;
    }

    private CustomerEntity buildNewCustomer(CustomerEntity customer, Long addressId) {
        customer.setAddressId(addressId);
        customer.setCreateDate(LocalDateTime.now());
        return customer;
    }

    private CountryEntity buildCountryDate(CountryEntity country) {
        country.setLastUpdate(LocalDateTime.now());
        return country;
    }

    private AddressEntity buildNewAddress(AddressEntity address, Long cityId) {
        address.setLastUpdate(LocalDateTime.now());
        address.setCityId(cityId);
        return address;
    }

    private CityEntity buildNewCity(CityEntity city, Long countryId) {
        city.setLastUpdate(LocalDateTime.now());
        city.setCountryId(countryId);
        return city;
    }

    private String buildFilmUpper(String title) {
        String newTitle = title.toUpperCase();
        return newTitle;
    }

}
