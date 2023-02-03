package pl.jacekrg.AlpineGuesthouse.domain.room.dto;

import pl.jacekrg.AlpineGuesthouse.domain.room.BedType;

import java.util.List;

public record RoomCreateRestDTO(
        String roomNumber,
        List<BedType> beds,
        String description,
        List<String> photosUrls)
{}