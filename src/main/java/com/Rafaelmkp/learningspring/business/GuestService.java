package com.Rafaelmkp.learningspring.business;

import com.Rafaelmkp.learningspring.data.Guest;
import com.Rafaelmkp.learningspring.data.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<GuestDTO> getAllGuests() {
        List<GuestDTO> guests = new ArrayList<>();
        Iterable<Guest> guestEntities =  guestRepository.findAll();
        guestEntities.forEach(guest -> {
            GuestDTO dto = new GuestDTO();
            dto.setFirstName(guest.getFirstName());
            dto.setLastName(guest.getLastName());
            dto.setEmailAddress(guest.getEmailAddress());
            dto.setPhoneNumber(guest.getPhoneNumber());
            guests.add(dto);
        });

        guests.sort((GuestDTO o1, GuestDTO o2) -> {
            if(o1.getLastName().equals(o2.getLastName())) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            }
            return o1.getLastName().compareTo(o2.getLastName());
        });

        return guests;
    }
}
