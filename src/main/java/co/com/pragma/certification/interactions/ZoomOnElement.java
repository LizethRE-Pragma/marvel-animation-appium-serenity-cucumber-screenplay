package co.com.pragma.certification.interactions;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Map;


public class ZoomOnElement {
    private static final double PERCENT = 0.75;
    private static final int SPEED = 1500;

    public static Performable in(Target target) {
        return Task.where("Zoom in on element", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();

            WebElement element = target.resolveFor(actor).getElement();

            androidDriver.executeScript("mobile: pinchOpenGesture", Map.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "percent", PERCENT,
                    "speed", SPEED
            ));
        });
    }

    public static Performable out(Target target) {
        return Task.where("Zoom out on element", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();

            WebElement element = target.resolveFor(actor).getElement();

            androidDriver.executeScript("mobile: pinchCloseGesture", Map.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "percent", PERCENT,
                    "speed", SPEED
            ));
        });
    }
}