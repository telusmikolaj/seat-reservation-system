package org.telusmikolaj.domain.mapper;

import org.mapstruct.Mapper;
import org.telusmikolaj.api.dto.ReservationDto;
import org.telusmikolaj.domain.Reservation;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationDto toDto(Reservation reservation);
}
