package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    Repository repository = new Repository();
    Flight khvSvo = new Flight(1, 18500, "KHV", "SVO", 420);
    Flight sipDme = new Flight(2, 5600, "SIP", "DME", 180);
    Flight svoSin = new Flight(3, 23500, "SVO", "SIN", 450);
    Flight khvSvo2 = new Flight(4, 35000, "KHV", "SVO", 360);
    Flight dpsKhv = new Flight(5, 27600, "DPS", "KHV", 720);
    Flight ledAaq = new Flight(6, 6500, "LED", "AAQ", 190);

    @BeforeEach
    public void setUp() {
        repository.save(khvSvo);
        repository.save(sipDme);
        repository.save(svoSin);
        repository.save(khvSvo2);
        repository.save(dpsKhv);
        repository.save(ledAaq);
    }

    @Test
    public void shouldFindAll() {
        Flight[] actual = repository.findAll();
        Flight[] expected = new Flight[]{sipDme, ledAaq, khvSvo, svoSin, dpsKhv, khvSvo2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 3;
        repository.removeById(idToRemove);
        Flight[] actual = repository.findAll();
        Flight[] expected = new Flight[]{sipDme, ledAaq, khvSvo, dpsKhv, khvSvo2};
        assertArrayEquals(expected, actual);
    }
}