package com.Rafaelmkp.learningspring.web;

import com.Rafaelmkp.learningspring.business.GuestDTO;
import com.Rafaelmkp.learningspring.business.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestController {
    private final GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getAllGuests(Model model) {
        List<GuestDTO> guests = guestService.getAllGuests();
        model.addAttribute("guests", guests);

        return "allguests";
    }
}
