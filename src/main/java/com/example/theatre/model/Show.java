package com.example.theatre.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "shows", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"theatre_id", "screen", "start_time"})
})
public class Show {
    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "theatre_id", nullable = false)
    private UUID theatreId;

    @Column(name = "movie_id", nullable = false)
    private UUID movieId;

    private String screen;

    @Column(name = "start_time", nullable = false)
    private OffsetDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private OffsetDateTime endTime;

    private String language;

    private Integer seatsTotal;

    private Integer seatsAvailable;

    // getters and setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getTheatreId() { return theatreId; }
    public void setTheatreId(UUID theatreId) { this.theatreId = theatreId; }
    public UUID getMovieId() { return movieId; }
    public void setMovieId(UUID movieId) { this.movieId = movieId; }
    public String getScreen() { return screen; }
    public void setScreen(String screen) { this.screen = screen; }
    public OffsetDateTime getStartTime() { return startTime; }
    public void setStartTime(OffsetDateTime startTime) { this.startTime = startTime; }
    public OffsetDateTime getEndTime() { return endTime; }
    public void setEndTime(OffsetDateTime endTime) { this.endTime = endTime; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public Integer getSeatsTotal() { return seatsTotal; }
    public void setSeatsTotal(Integer seatsTotal) { this.seatsTotal = seatsTotal; }
    public Integer getSeatsAvailable() { return seatsAvailable; }
    public void setSeatsAvailable(Integer seatsAvailable) { this.seatsAvailable = seatsAvailable; }
}
