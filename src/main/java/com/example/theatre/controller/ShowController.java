package com.example.theatre.controller;

import com.example.theatre.model.Show;
import com.example.theatre.repo.ShowRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

    private final ShowRepository repo;

    public ShowController(ShowRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Show> create(@Valid @RequestBody Show show) {
        Show saved = repo.save(show);
        return ResponseEntity.status(201).body(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> get(@PathVariable UUID id) {
        return repo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Show>> listByTheatreAndDate(
            @RequestParam UUID theatreId,
            @RequestParam OffsetDateTime from,
            @RequestParam OffsetDateTime to
    ) {
        List<Show> list = repo.findByTheatreIdAndStartTimeBetween(theatreId, from, to);
        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> update(@PathVariable UUID id, @Valid @RequestBody Show show) {
        return repo.findById(id).map(existing -> {
            show.setId(existing.getId());
            Show s = repo.save(show);
            return ResponseEntity.ok(s);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
