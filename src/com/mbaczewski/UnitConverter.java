package com.mbaczewski;

import java.io.IOException;

public class UnitConverter {


    public double convertCelsiusToFahrenheit(double celsiusTemperature) throws IOException{
        if ( celsiusTemperature > -273.15) {
            return celsiusTemperature * 1.8 + 32;
        } else {
            throw new IOException("Wartość mnijesza niż 0 bezwzględne");
        }

    }

    public double convertFahrenheitToCelsius(double fahrenheitTemperature) throws IOException {
        if (fahrenheitTemperature > -459.67) {
            return (fahrenheitTemperature - 32) / 1.8;
        } else {
            throw new IOException("Wartość mnijesza niż 0 bezwzględne");
        }

    }

}
