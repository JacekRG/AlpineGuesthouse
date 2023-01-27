package pl.jacekrg.domain.reservation;

import lombok.Data;
import pl.jacekrg.domain.guest.Guest;
import pl.jacekrg.domain.room.Room;

import java.time.LocalDate;

@Data
public class Reservation {
    private LocalDate fromDate;
    private LocalDate toDate;
    private Guest guest;
    private Room room;
}
