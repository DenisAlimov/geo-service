package ru.netology.i18n;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LocalizationServiceImplTest {

    LocalizationServiceImpl loc = new LocalizationServiceImpl();
    public static int i = 1;

    @BeforeEach
    public void startMsg() {
        System.out.println("Test " + i + " started");
    }

    @AfterEach
    public void endMsg() {
        System.out.println("Test " + i + " ended");
        i++;
    }

    @Test
    public void testLocale() {
        //arrange
        Country country = Country.RUSSIA;
        final String expected = "Добро пожаловать";

        //act
        String result = loc.locale(country);

        //assert
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @EnumSource (value = Country.class, names = { "GERMANY", "USA", "BRAZIL"})
    public void testLocale(Country country) {
        //arrange
        final String expected = "Welcome";

        //act
        String result = loc.locale(country);

        //assert
        assertEquals(expected, result);
    }
}