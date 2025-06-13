package com.udea.kbtflights.controller;

import com.udea.kbtflights.exception.InvalidRatingException;
import com.udea.kbtflights.exception.ModelNotFoundException;
import com.udea.kbtflights.model.Flight;
import com.udea.kbtflights.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/create")
    public String createFlight(@RequestBody Flight flight) throws InvalidRatingException {
        if(flight.getRating() > 5)
            throw new InvalidRatingException("Rating is greater than 5");
        flightService.createFlight(flight);
        return "Flight created successfully";
    }

    @GetMapping("/all")
    public Iterable<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable int id) {
        Optional<Flight> flight = flightService.getFlightById(id);
        if (flight.isPresent()) {
            return flight.get();
        }
        throw new ModelNotFoundException(id);
    }

    @GetMapping("/top-flights")
    public ResponseEntity<List<Flight>> getTopFlights() {
        List<Flight> flights = flightService.viewBestFlights();
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        return flightService.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable int id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>("Flight deleted successfully" + id, HttpStatus.OK);
    }
}
