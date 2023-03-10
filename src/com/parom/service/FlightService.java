package com.parom.service;

import com.parom.dao.FlightDao;
import com.parom.dto.FlightDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {
    }

    private final FlightDao flightDao = FlightDao.getInstance();

    public List<FlightDTO> findAll() {
        return flightDao.findAll().stream()
                .map(flight -> FlightDTO.builder()
                        .id(flight.getId())
                        .description("""
                                %s - %s - %s
                                """.formatted(flight.getDepartureAirportCode(), flight.getArrivalAirportCode(), flight.getStatuse()))
                        .build()
                )
                .collect(Collectors.toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }

}
