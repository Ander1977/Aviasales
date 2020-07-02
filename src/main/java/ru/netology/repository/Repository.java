package ru.netology.repository;

import ru.netology.domain.Flight;

import java.util.Arrays;

public class Repository {
    private Flight[] flights = new Flight[0];

    public void save(Flight flight){
        int length = flights.length + 1;
        Flight[] tmp = new Flight[length];
        System.arraycopy(flights, 0, tmp, 0, flights.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = flight;
        flights = tmp;
    }

    public Flight[] findAll(){
        return flights;
    }

    public void removeById(int id) {
        int length = flights.length - 1;
        Flight[] tmp = new Flight[length];
        int index = 0;
        for (Flight flight : flights){
            if (flight.getId() != id){
                tmp[index] = flight;
                index++;
            }
        }
        flights = tmp;
    }
}
