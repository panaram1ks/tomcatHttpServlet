package com.parom.dto;

import java.util.Objects;

public class TicketDTO {

    private Long id;
    private String passengerNo;
    private String getPassengerName;

    public TicketDTO(Long id, String passengerNo, String getPassengerName) {
        this.id = id;
        this.passengerNo = passengerNo;
        this.getPassengerName = getPassengerName;
    }

    public TicketDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getGetPassengerName() {
        return getPassengerName;
    }

    public void setGetPassengerName(String getPassengerName) {
        this.getPassengerName = getPassengerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDTO ticketDTO = (TicketDTO) o;
        return Objects.equals(id, ticketDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
               "id=" + id +
               ", passengerNo='" + passengerNo + '\'' +
               ", getPassengerName='" + getPassengerName + '\'' +
               '}';
    }
}
