package com.parom.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Flight {

    private Long id;
    private String flightNo;
    private LocalDateTime departureDate;
    private String departureAirportCode;
    private LocalDateTime arrivalDate;
    private String arrivalAirportCode;
    private Integer aircraftId;
    private FlightStatuse statuse;

}
