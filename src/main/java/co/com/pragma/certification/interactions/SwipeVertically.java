package co.com.pragma.certification.interactions;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;


public class SwipeVertically {
    private static final Duration GESTURE_DURATION = Duration.ofMillis(1500);

    public static Performable toDown() {
        return Task.where("Swipe vertically to down", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();
            Dimension dimension = androidDriver.manage().window().getSize();

            int startX = dimension.getWidth() / 2;
            int startY = (int) (dimension.getHeight() * 0.2);
            int endY = (int) (dimension.getHeight() * 0.8);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(GESTURE_DURATION, PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            androidDriver.perform(Arrays.asList(swipe));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static Performable toUp() {
        return Task.where("Swipe vertically to up", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();
            Dimension dimension = androidDriver.manage().window().getSize();

            int startX = dimension.getWidth() / 2;
            int startY = (int) (dimension.getHeight() * 0.8);
            int endY = (int) (dimension.getHeight() * 0.2);

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(GESTURE_DURATION, PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            androidDriver.perform(Arrays.asList(swipe));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}