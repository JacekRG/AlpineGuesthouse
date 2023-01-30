package pl.jacekrg.AlpineGuesthouse.controllers.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import pl.jacekrg.AlpineGuesthouse.domain.guest.Gender;

import java.time.LocalDate;

@Data
public class GuestCreationDTO {

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @Past(message = "Data urodzenia musi być w przeszłości")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private final LocalDate dateOfBirth;

    private final Gender gender;
}