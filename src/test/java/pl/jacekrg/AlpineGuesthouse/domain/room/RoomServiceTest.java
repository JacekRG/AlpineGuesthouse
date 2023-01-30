package pl.jacekrg.AlpineGuesthouse.domain.room;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomServiceTest {

    @Test
    public void createNewRoomValidData() {

        //give
        RoomRepository roomRepository = Mockito.mock(RoomRepository.class);
        ArgumentCaptor<Room> roomCaptor = ArgumentCaptor.forClass(Room.class);
        RoomService rs = new RoomService(roomRepository);
        List<BedType> bedTypes = Arrays.asList(BedType.DOUBLE, BedType.SINGLE, BedType.SINGLE);
        Room r = new Room("102", bedTypes);

        //when
        rs.createNewRoom("102", "2+1+1");



        //then
        Mockito.verify(roomRepository).save(roomCaptor.capture());
        assertEquals("102", roomCaptor.getValue().getNumber());
        assertEquals(3, roomCaptor.getValue().getBeds().size());
        assertEquals(BedType.DOUBLE, roomCaptor.getValue().getBeds().get(0));
        assertEquals(BedType.SINGLE, roomCaptor.getValue().getBeds().get(1));
        assertEquals(BedType.SINGLE, roomCaptor.getValue().getBeds().get(2));
    }
}