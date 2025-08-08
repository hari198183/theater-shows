package com.example.theatre.repo;

import com.example.theatre.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ShowRepository extends JpaRepository<Show, UUID> {
    List<Show> findByTheatreIdAndStartTimeBetween(UUID theatreId, OffsetDateTime start, OffsetDateTime end);
}
