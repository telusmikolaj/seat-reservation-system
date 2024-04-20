package org.telusmikolaj.api.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationForm {
    private Long eventId;
    private Long seatId;
}
