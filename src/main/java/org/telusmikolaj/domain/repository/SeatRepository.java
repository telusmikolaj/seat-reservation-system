package org.telusmikolaj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telusmikolaj.domain.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByEventIdAndIsReservedIsFalse(Long eventId);
}
