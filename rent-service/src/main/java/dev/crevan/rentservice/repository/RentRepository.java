package dev.crevan.rentservice.repository;

import dev.crevan.rentservice.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentRepository extends JpaRepository<Rent, Long> {

    List<Rent> findRentsByAnimal(final String animal);
}
