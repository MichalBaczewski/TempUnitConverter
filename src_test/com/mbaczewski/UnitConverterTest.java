package com.mbaczewski;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UnitConverterTest {

    private UnitConverter unitConverter;

    @BeforeEach
    protected void setUp() {
        unitConverter = new UnitConverter();
    }

    @Disabled
    @Test
    protected void shouldReturn50DegInFahrenheitWhenGet10DegInCelsius() throws IOException {
        // given
        
        // when
        double result = unitConverter.convertCelsiusToFahrenheit(10);
        // then
        assertEquals(50, result);
    }

    @Test
    protected void shouldThrowIOExceptionWhenGetNumberUnderZeroAbsInCelsius() {
        // given

        // when

        // then
        IOException result = assertThrows(IOException.class, ()
                -> unitConverter.convertCelsiusToFahrenheit(-280));
        assertEquals("Wartość mnijesza niż 0 bezwzględne", result.getMessage());
    }

    @Disabled
    @Test
    protected void shouldReturn37dot78DegInCelsiusWhenGet100InFahrenheit() throws IOException {
        // given
        
        // when
        double result = unitConverter.convertFahrenheitToCelsius(100);
        // then
        assertEquals(37.78, result, 0.01);
    }

    @Test
    protected void shouldThrowIOExceptionWhenGetNumberUnderZeroAbsInFahrenheit() {
        // given
        
        // when
        
        // then
        IOException result = assertThrows(IOException.class, ()
        -> unitConverter.convertFahrenheitToCelsius(-500));
        assertEquals("Wartość mnijesza niż 0 bezwzględne", result.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"-200, -328", "-10, 14", "40, 104", "100, 212", "300, 572"})
    void testWithCSVSourceConversionCelsiusToFahrenheit(double celsTemp, double fahrTemp) throws IOException {
        double result = unitConverter.convertCelsiusToFahrenheit(celsTemp);
        assertEquals(result, fahrTemp, 0.01);
    }

    @ParameterizedTest
    @CsvSource({"-400, -240", "0, -17.78", "40, 4.44", "200, 93.33", "400, 204.44"})
    void testWithCSVSourceConversionFahrenheitToCelsius(double fahrTemp, double celsTemp) throws IOException {
        double result = unitConverter.convertFahrenheitToCelsius(fahrTemp);
        assertEquals(result, celsTemp, 0.01);
    }

}