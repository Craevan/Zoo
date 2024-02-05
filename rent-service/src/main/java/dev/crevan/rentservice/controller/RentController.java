package dev.crevan.rentservice.controller;

import dev.crevan.rentservice.model.Rent;
import dev.crevan.rentservice.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rents")
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    @GetMapping("/animal/{animal}")
    public List<Rent> getFlights(@PathVariable final String animal) {
        return rentService.getRentsByAnimal(animal);
    }
}
