package org.telusmikolaj.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime dateTime;

    private String location;

    @OneToMany(mappedBy = "event")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "event")
    private List<Seat> seats;

}
