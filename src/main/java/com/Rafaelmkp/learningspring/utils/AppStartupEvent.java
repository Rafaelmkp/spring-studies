package com.Rafaelmkp.learningspring.utils;

import com.Rafaelmkp.learningspring.business.ReservationService;
import com.Rafaelmkp.learningspring.business.RoomReservation;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private ReservationService reservationService;
    private DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date = dateUtils.createDateFromDateString("2022-01-01");
        List<RoomReservation> reservations = reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
    }
}
