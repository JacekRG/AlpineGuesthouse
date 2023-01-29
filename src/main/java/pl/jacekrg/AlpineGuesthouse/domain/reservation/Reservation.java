package pl.jacekrg.AlpineGuesthouse.domain.reservation;

import lombok.Data;
import pl.jacekrg.AlpineGuesthouse.domain.guest.Guest;
import pl.jacekrg.AlpineGuesthouse.domain.room.Room;

import java.time.LocalDate;

@Data
public class Reservation {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Guest guest;
    private Room room;
}
