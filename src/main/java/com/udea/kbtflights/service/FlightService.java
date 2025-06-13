package com.udea.kbtflights.service;

import com.udea.kbtflights.dao.IFlightDAO;
import com.udea.kbtflights.exception.ModelNotFoundException;
import com.udea.kbtflights.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private IFlightDAO flightDAO;

    public Flight createFlight(Flight flight) {
        return flightDAO.save(flight);
    }

    public String deleteFlight(long id) {
        flightDAO.deleteById(id);
        return "The Flight" + id + "has been deleted" ;
    }

    public Iterable<Flight> getAllFlights() {
        return flightDAO.findAll();
    }

    public Optional<Flight> getFlightById(long id) {
        return flightDAO.findById(id);
    }

    public Flight updateFlight(long id, Flight flight) {
        return flightDAO.findById(id)
                .map( existFlight -> {
                    existFlight.setPlaneName(flight.getPlaneName());
                    existFlight.setNumberFlight(flight.getNumberFlight());
                    existFlight.setOrigin(flight.getOrigin());
                    existFlight.setDestination(flight.getDestination());
                    existFlight.setRating(flight.getRating());
                    existFlight.setPlanVuelo(flight.getPlanVuelo());
                    existFlight.setCapacity(flight.getCapacity());
                    existFlight.setChecked(flight.getChecked());
                    return flightDAO.save(existFlight);
                })
                .orElseThrow(() -> new RuntimeException("Could not find flight with id: " + id));
    }

    public List<Flight> viewBestFlights() throws ModelNotFoundException {
        List<Flight> bestFlights = flightDAO.viewBestFlight();
        if (bestFlights.size() > 0) {
            return bestFlights;
        } else throw new ModelNotFoundException("No flight found rating > 4");
    }
}
