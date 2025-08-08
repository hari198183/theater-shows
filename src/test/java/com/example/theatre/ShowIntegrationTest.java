package com.example.theatre;

import com.example.theatre.model.Show;
import com.example.theatre.repo.ShowRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@Testcontainers
public class ShowIntegrationTest {

    @Container
    public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @BeforeAll
    public static void setUp() {
        System.setProperty("SPRING_DATASOURCE_URL", postgres.getJdbcUrl());
        System.setProperty("SPRING_DATASOURCE_USERNAME", postgres.getUsername());
        System.setProperty("SPRING_DATASOURCE_PASSWORD", postgres.getPassword());
    }

    @Autowired
    private ShowRepository repo;

    @Test
    public void testCreateAndList() {
        Show s = new Show();
        s.setTheatreId(UUID.randomUUID());
        s.setMovieId(UUID.randomUUID());
        s.setScreen("Screen 1");
        s.setStartTime(OffsetDateTime.now().plusDays(1));
        s.setEndTime(OffsetDateTime.now().plusDays(1).plusHours(2));
        s.setLanguage("EN");
        s.setSeatsTotal(100);
        s.setSeatsAvailable(100);

        Show saved = repo.save(s);
        Assertions.assertNotNull(saved.getId());

        List<Show> list = repo.findByTheatreIdAndStartTimeBetween(s.getTheatreId(),
                OffsetDateTime.now(), OffsetDateTime.now().plusDays(2));
        Assertions.assertFalse(list.isEmpty());
    }
}
