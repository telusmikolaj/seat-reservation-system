package org.telusmikolaj.domain.mapper;

import org.mapstruct.Mapper;
import org.telusmikolaj.api.dto.EventDto;
import org.telusmikolaj.api.form.EventForm;
import org.telusmikolaj.domain.Event;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventDto toDto(Event event);

    List<EventDto> toDto(List<Event> events);
    Event toEntity(EventForm eventForm);
}
