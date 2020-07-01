package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Flight;
import ru.netology.domain.FlightByTimeAscComparator;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repository = new Repository();
    Manager manager = new Manager(repository);
    FlightByTimeAscComparator comparator = new FlightByTimeAscComparator();

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
    void shouldSearchIfFlightFind() {
        Flight[] actual = manager.searchBy("KHV", "SVO");
        Flight[] expected = new Flight[]{khvSvo, khvSvo2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchIfFlightNotFind() {
        Flight[] actual = manager.searchBy("DME", "KHV");
        Flight[] expected = new Flight[0];
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchFindAllCompar() {
        Flight[] actual = manager.findAllCompar("KHV", "SVO", comparator);
        Flight[] expected = new Flight[]{khvSvo2, khvSvo};
        assertArrayEquals(expected, actual);
    }

}