package ru.netology.geo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoServiceImplTest {
    public static int i = 1;
    GeoServiceImpl geo;

    @BeforeEach
    public void startMsg() {
        geo = new GeoServiceImpl();
        System.out.println("Test " + i + " started");
    }

    @AfterEach
    public void endMsg() {
        System.out.println("Test " + i + " ended");
        i++;
    }

    @Test
    public void testLocationByIp1() {
        //arrange
        final String NEW_YORK_IP = "96.44.183.149";
        final String expected = "New York";

        //act
        final Location find = geo.byIp(NEW_YORK_IP);
        final String result = find.getCity();

        //assert
        assertEquals(expected, result);
    }

    @Test
    public void testLocationByIp2() {
        //arrange
        final String MOSCOW_IP = "172.0.32.11";
        final String expected = "Lenina";

        //act
        final Location find = geo.byIp(MOSCOW_IP);
        final String result = find.getStreet();

        //assert
        assertEquals(expected, result);
    }
}