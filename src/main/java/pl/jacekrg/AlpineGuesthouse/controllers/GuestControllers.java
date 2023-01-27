package pl.jacekrg.AlpineGuesthouse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jacekrg.domain.guest.Gender;
import pl.jacekrg.domain.guest.Guest;

import java.time.LocalDate;

@Controller
public class GuestControllers {

    @GetMapping("/guests")
    public String guests(Model model) {
        Guest guest = new Guest("Robert", "Kubica", LocalDate.of(
                1984, 12, 7), Gender.MALE);
        model.addAttribute("guest", guest);
        return "guests";
    }
}

