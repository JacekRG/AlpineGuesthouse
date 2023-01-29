package pl.jacekrg.AlpineGuesthouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.jacekrg.AlpineGuesthouse.controllers.dto.GuestCreationDTO;
import pl.jacekrg.AlpineGuesthouse.domain.guest.GuestService;

@Controller
public class GuestController {

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService service) {
        this.guestService = service;
    }

    @GetMapping("/guests")
    public String guests(Model model) {
        model.addAttribute("guests", this.guestService.findAll());
        return "guests";
    }

    @GetMapping("/createNewGuest")
    public String createNewGuest() {
        return "createNewGuest";
    }

    @PostMapping("/createNewGuest")
    public String handleCreateNewGuest(GuestCreationDTO dto) {

        this.guestService.createNewGuest(dto);

        return "redirect:guests";
    }

}