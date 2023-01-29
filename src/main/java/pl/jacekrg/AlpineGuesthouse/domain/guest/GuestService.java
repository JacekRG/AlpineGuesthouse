package pl.jacekrg.AlpineGuesthouse.domain.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jacekrg.AlpineGuesthouse.controllers.dto.GuestCreationDTO;

import java.time.LocalDate;
import java.util.List;

@Service
public class GuestService {

    private GuestRepository repository;

    @Autowired
    public GuestService(GuestRepository repository) {
        this.repository = repository;
    }

    public List<Guest> findAll() {
        return this.repository.findAll();
    }

    public void createNewGuest(GuestCreationDTO dto) {
        this.repository.createNewGuest(dto.getFirstName(), dto.getLastName(), dto.getDateOfBirth(), dto.getGender());
    }
}