package org.telusmikolaj.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private boolean isReserved;

    @OneToOne(mappedBy = "seat")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

}
