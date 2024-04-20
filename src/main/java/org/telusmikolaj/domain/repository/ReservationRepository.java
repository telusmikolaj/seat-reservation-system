package org.telusmikolaj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telusmikolaj.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
