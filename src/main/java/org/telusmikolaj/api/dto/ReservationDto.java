package org.telusmikolaj.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDto {

    Long id;

    private EventDto event;

    private SeatDto seat;

    private LocalDateTime reservationDate;
}
