package org.telusmikolaj.domain.mapper;

import org.mapstruct.Mapper;
import org.telusmikolaj.api.dto.SeatDto;
import org.telusmikolaj.domain.Seat;

import java.util.List;
@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatDto toDto(Seat seat);
    List<SeatDto> toDto(List<Seat> seats);
}
