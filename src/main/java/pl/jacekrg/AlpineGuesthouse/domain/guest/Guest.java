package pl.jacekrg.AlpineGuesthouse.domain.guest;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Setter(value = AccessLevel.NONE)
@Entity
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;

    Guest() {

    }

    public Guest(String firstName, String lastName, LocalDate birthDate, Gender gender) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;

    }

    public void update(String firstName, String lastName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
    }
}