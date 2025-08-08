package com.example.theatre.dto;

import java.time.OffsetDateTime;
import java.util.UUID;

public class ShowDto {
    public UUID id;
    public UUID theatreId;
    public UUID movieId;
    public String screen;
    public OffsetDateTime startTime;
    public OffsetDateTime endTime;
    public String language;
    public Integer seatsTotal;
    public Integer seatsAvailable;
}
