package com.aydincanaltun.demo.web;

import com.aydincanaltun.demo.business.ReservationService;
import com.aydincanaltun.demo.data.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("Guests")
public class GuestController {
    private final ReservationService reservationService;

    public GuestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getGuests(Model model) {
        List<Guest> guestList = reservationService.getGuests();
        model.addAttribute("guests", guestList);
        return "guests";
    }
}
