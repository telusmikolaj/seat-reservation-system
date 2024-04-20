package org.telusmikolaj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.telusmikolaj.api.dto.SeatDto;
import org.telusmikolaj.domain.mapper.SeatMapper;
import org.telusmikolaj.domain.repository.EventRepository;
import org.telusmikolaj.domain.repository.SeatRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final EventRepository eventRepository;
    private final SeatMapper seatMapper;

    public List<SeatDto> getFreeSeatsForEvent(Long eventId) {
        if (!eventRepository.existsById(eventId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event with id " + eventId + " not found");
        }
        return seatMapper.toDto(seatRepository.findAllByEventIdAndIsReservedIsFalse(eventId));
    }
}
