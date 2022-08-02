package com.Rafaelmkp.learningspring.data;

import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findReservationByDate(Date date);
}
