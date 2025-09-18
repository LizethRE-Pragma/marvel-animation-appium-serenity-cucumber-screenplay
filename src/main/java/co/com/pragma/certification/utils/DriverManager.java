package co.com.pragma.certification.utils;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    @Getter
    @Setter
    private static WebDriver driver;
}
