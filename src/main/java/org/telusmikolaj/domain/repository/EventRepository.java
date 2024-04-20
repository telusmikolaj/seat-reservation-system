package org.telusmikolaj.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telusmikolaj.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
