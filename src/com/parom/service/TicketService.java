package com.parom.service;

import com.parom.dao.TicketDao;
import com.parom.dto.TicketDTO;
import com.parom.entity.Ticket;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {

    private final TicketDao ticketDao = TicketDao.getInstance();

    private static final TicketService INSTANCE = new TicketService();

    private TicketService() {}

    public static TicketService getInstance() {
        return INSTANCE;
    }

    public List<TicketDTO> findAllByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId)
                .stream()
                .map(ticket -> new TicketDTO(
                        ticket.getId(),
                        ticket.getPassengerNo(),
                        ticket.getPassengerName()
                ))
                .collect(Collectors.toList());
    }
}
