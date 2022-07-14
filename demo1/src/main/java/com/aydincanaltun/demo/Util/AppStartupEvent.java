package com.aydincanaltun.demo.Util;

import com.aydincanaltun.demo.business.ReservationService;
import com.aydincanaltun.demo.business.RoomReservation;
import com.aydincanaltun.demo.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    private final ReservationService reservationService;
    private final DateUtils dateUtils;

    public AppStartupEvent(ReservationService reservationService, DateUtils dateUtils) {
        this.reservationService = reservationService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Date date =  dateUtils.createDateFromDateString("2020-01-01");
        List<RoomReservation> reservations = reservationService.getRoomReservationsForDate(date);
        reservations.forEach(System.out::println);
    }
}
