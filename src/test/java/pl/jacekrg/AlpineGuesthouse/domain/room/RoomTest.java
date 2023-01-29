package pl.jacekrg.AlpineGuesthouse.domain.room;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RoomTest {


    @Test
    public void testRoomSizeZero() {

        Room r = new Room("102", new ArrayList<>());
        assertEquals(0, r.getSize());
    }

    @Test
    public void testRoomSizeNull() {

        assertThrows(IllegalArgumentException.class, () -> {
            Room r = new Room("102", null);
        });

    }

    @Test
    public void testRoomSize() {

        Room r = new Room("102", Arrays.asList(BedType.DOUBLE, BedType.SINGLE));
        assertEquals(3, r.getSize());
    }

}