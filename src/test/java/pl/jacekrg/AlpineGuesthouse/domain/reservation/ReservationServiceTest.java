package pl.jacekrg.AlpineGuesthouse.domain.reservation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.jacekrg.AlpineGuesthouse.domain.room.RoomService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReservationServiceTest {


    @Test
    public void testIfGetAvRoomFailsForTooSmallSize() {

        //given
        ReservationRepository repo = Mockito.mock(ReservationRepository.class);
        RoomService rs = Mockito.mock(RoomService.class);
        ReservationService reservationService = new ReservationService(repo, rs);

        //when then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    reservationService.getAvaiableRooms(LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.DAYS), -5);
                }
        );
    }

    @Test
    public void testIfGetAvRoomFailsForTooBigSize() {

        //given
        ReservationRepository repo = Mockito.mock(ReservationRepository.class);
        RoomService rs = Mockito.mock(RoomService.class);
        ReservationService reservationService = new ReservationService(repo, rs);

        //when then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    reservationService.getAvaiableRooms(LocalDate.now(), LocalDate.now().plus(1, ChronoUnit.DAYS), 15);
                }
        );
    }

    @Test
    public void testIfGetAvRoomFailsForSameDates() {

        //given
        ReservationRepository repo = Mockito.mock(ReservationRepository.class);
        RoomService rs = Mockito.mock(RoomService.class);
        ReservationService reservationService = new ReservationService(repo, rs);

        //when then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    reservationService.getAvaiableRooms(LocalDate.now(), LocalDate.now(), 5);
                }
        );
    }

    @Test
    public void testIfGetAvRoomFailsForToBeforeFRom() {

        //given
        ReservationRepository repo = Mockito.mock(ReservationRepository.class);
        RoomService rs = Mockito.mock(RoomService.class);
        ReservationService reservationService = new ReservationService(repo, rs);

        //when then
        assertThrows(IllegalArgumentException.class,
                () -> {
                    reservationService.getAvaiableRooms(LocalDate.now().plus(1, ChronoUnit.DAYS), LocalDate.now(), 5);
                }
        );
    }

}