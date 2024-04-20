package org.telusmikolaj.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telusmikolaj.api.dto.EventDto;
import org.telusmikolaj.api.dto.ReservationDto;
import org.telusmikolaj.api.dto.SeatDto;
import org.telusmikolaj.api.form.ReservationForm;
import org.telusmikolaj.service.EventService;
import org.telusmikolaj.service.ReservationService;
import org.telusmikolaj.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
@Slf4j
public class ReservationController {

    private final ReservationService reservationService;
    private final EventService eventService;
    private final SeatService seatService;

    @Operation(summary = "Get all events")
    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @Operation(summary = "Get free seats for a specific event")
    @GetMapping("/events/{eventId}/seats/free")
    public ResponseEntity<List<SeatDto>> getFreeSeatsForEvent(@PathVariable("eventId") Long eventId) {
        log.info(eventId.toString());
        return ResponseEntity.ok(seatService.getFreeSeatsForEvent(eventId));
    }

    @Operation(summary = "Get a reservation by its ID")
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    @Operation(summary = "Create a new reservation")
    @PostMapping
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationForm reservation) {
        return ResponseEntity.ok(reservationService.createReservation(reservation));
    }

    @Operation(summary = "Update an existing reservation")
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable("id") Long id, @RequestBody ReservationForm reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(id, reservation));
    }

    @Operation(summary = "Delete a reservation by its ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }

}