package co.com.pragma.certification.interactions;

import co.com.pragma.certification.models.Point;
import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;


public class Tap {
    private static final Duration GESTURE_DURATION = Duration.ofMillis(800);

    public static Performable oneTap(Point point) {
        return Task.where("Tap", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.getX(), point.getY()));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            androidDriver.perform(Arrays.asList(tap));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static Performable doubleTap(Point point) {
        return Task.where("Double Tap", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence tap1 = new Sequence(finger1, 1);
            tap1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.getX(), point.getY()));
            tap1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
            Sequence tap2 = new Sequence(finger2, 1);
            tap2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.getX(), point.getY()));
            tap2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            //tap2.addAction(new Pause(finger2, Duration.ofMillis(50)));
            tap2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            androidDriver.perform(Arrays.asList(tap1, tap2));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}