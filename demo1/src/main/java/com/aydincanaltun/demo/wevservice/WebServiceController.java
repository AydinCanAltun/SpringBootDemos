package com.aydincanaltun.demo.wevservice;

import com.aydincanaltun.demo.Util.DateUtils;
import com.aydincanaltun.demo.business.ReservationService;
import com.aydincanaltun.demo.business.RoomReservation;
import com.aydincanaltun.demo.data.Guest;
import com.aydincanaltun.demo.data.Room;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date", required = false) String dateString) {
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return reservationService.getRoomReservationsForDate(date);
    }

    @RequestMapping(path="/guests", method = RequestMethod.GET)
    public List<Guest> getGuests() {
        return reservationService.getGuests();
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGuest(@RequestBody Guest guest) {
        reservationService.addGuest(guest);
    }

    @RequestMapping(path="rooms", method = RequestMethod.GET)
    public List<Room> getRooms() {
        return reservationService.getRooms();
    }

}
