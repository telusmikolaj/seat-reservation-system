package org.telusmikolaj.api.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class EventForm {
    private String name;
    private LocalDateTime dateTime;

}
