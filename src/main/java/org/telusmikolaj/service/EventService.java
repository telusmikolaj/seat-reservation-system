package org.telusmikolaj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telusmikolaj.api.dto.EventDto;
import org.telusmikolaj.domain.mapper.EventMapper;
import org.telusmikolaj.domain.repository.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    public List<EventDto> getAllEvents() {
        return eventMapper.toDto(eventRepository.findAll());
    }
}
