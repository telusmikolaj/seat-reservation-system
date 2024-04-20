package org.telusmikolaj.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDto {
    private Long id;
    private String number;
    private boolean isReserved;

}
