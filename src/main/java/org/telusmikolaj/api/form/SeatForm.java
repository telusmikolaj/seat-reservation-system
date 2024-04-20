package org.telusmikolaj.api.form;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telusmikolaj.domain.Reservation;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatForm {
    private boolean isReserved;

    private ReservationForm reservation;
}
