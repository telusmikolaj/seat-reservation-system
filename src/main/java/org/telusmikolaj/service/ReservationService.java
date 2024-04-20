package org.telusmikolaj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.telusmikolaj.api.dto.ReservationDto;
import org.telusmikolaj.api.form.ReservationForm;
import org.telusmikolaj.domain.Event;
import org.telusmikolaj.domain.Reservation;
import org.telusmikolaj.domain.Seat;
import org.telusmikolaj.domain.mapper.ReservationMapper;
import org.telusmikolaj.domain.repository.EventRepository;
import org.telusmikolaj.domain.repository.ReservationRepository;
import org.telusmikolaj.domain.repository.SeatRepository;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final EventRepository eventRepository;
    private final SeatRepository seatRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationDto getReservationById(Long id) {
        return reservationRepository.findById(id)
                .map(reservationMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
    }

    public ReservationDto createReservation(ReservationForm reservationForm) {
        Event event = getEvent(reservationForm.getEventId());
        Seat seat = getSeat(reservationForm.getSeatId());

        if (seat.isReserved()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Seat is already reserved");
        }

        seat.setReserved(true);

        return reservationMapper.toDto(reservationRepository.save(new Reservation(event, seat)));
    }

    public ReservationDto updateReservation(Long id, ReservationForm reservationForm) {
        Reservation reservation = getReservation(id);
        Event event = getEvent(reservationForm.getEventId());
        Seat newSeat = getSeat(reservationForm.getSeatId());

        if (newSeat.isReserved()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Seat is already reserved");
        }

        Seat currentSeat = reservation.getSeat();

        if (currentSeat != null) {
            currentSeat.setReserved(false);
        }

        reservation.setEvent(event);
        reservation.setSeat(newSeat);
        newSeat.setReserved(true);

        return reservationMapper.toDto(reservationRepository.save(reservation));

    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        reservation.getSeat().setReserved(false);
        reservationRepository.delete(reservation);
    }

    private Event getEvent(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));
    }

    private Seat getSeat(Long id) {
        return seatRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
    }

    private Reservation getReservation(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));
    }

}
