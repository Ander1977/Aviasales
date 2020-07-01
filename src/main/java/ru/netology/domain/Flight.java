package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight implements Comparable<Flight> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int flightTime;

    @Override
    public int compareTo(Flight o) {
        return price - o.price;
    }

    public boolean matches(String from, String to) {
        return departure.equalsIgnoreCase(from) && arrival.equalsIgnoreCase(to);
    }
}