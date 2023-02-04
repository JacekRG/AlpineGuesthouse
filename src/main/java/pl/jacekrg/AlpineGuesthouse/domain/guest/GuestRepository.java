package pl.jacekrg.AlpineGuesthouse.domain.guest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long> {

    Optional<Guest> findTop1ByCustomerIdAndFirstNameAndLastNameAndBirthDate(
            String customerId,
            String firstName,
            String lastName,
            LocalDate birthDate
    );
}