package com.parom.dto;

import lombok.*;

//@AllArgsConstructor
//@Getter
//@ToString
//@EqualsAndHashCode
@Value
@Builder
public class FlightDTO {

    private final Long id;
    private final String description;

    protected boolean canEqual(final Object other) {
        return other instanceof FlightDTO;
    }

}
