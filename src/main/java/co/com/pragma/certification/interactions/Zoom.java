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


public class Zoom {
    private static final Duration GESTURE_DURATION = Duration.ofMillis(1500);

    public static Performable in() {
        return Task.where("Zoom in", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();
            Dimension size = androidDriver.manage().window().getSize();

            int centerX = size.getWidth() / 2;
            int centerY = size.getHeight() / 2;

            int startX1 = centerX + 30; // One finger
            int startY1 = centerY - 60;
            int endX1 = centerX + 250;
            int endY1 = centerY - 500;

            int startX2 = centerX - 30;// Two finger
            int startY2 = centerY + 60;
            int endX2 = centerX - 250;
            int endY2 = centerY + 500;

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

            Sequence seq1 = new Sequence(finger1, 1);
            seq1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX1, startY1));
            seq1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            //seq1.addAction(new Pause(finger1, Duration.ofMillis(50)));
            seq1.addAction(finger1.createPointerMove(GESTURE_DURATION, PointerInput.Origin.viewport(), endX1, endY1));
            seq1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            Sequence seq2 = new Sequence(finger2, 1);
            seq2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX2, startY2));
            seq2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            //seq2.addAction(new Pause(finger2, Duration.ofMillis(50)));
            seq2.addAction(finger2.createPointerMove(GESTURE_DURATION, PointerInput.Origin.viewport(), endX2, endY2));
            seq2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            androidDriver.perform(Arrays.asList(seq1, seq2));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static Performable out() {
        return Task.where("Zoom out", actor -> {
            AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();
            Dimension size = androidDriver.manage().window().getSize();

            int centerX = size.getWidth() / 2;
            int centerY = size.getHeight() / 2;

            int startX1 = centerX + 250; // One finger
            int startY1 = centerY - 500;
            int endX1 = centerX + 30;
            int endY1 = centerY - 60;

            int startX2 = centerX - 250; // Two finger
            int startY2 = centerY + 500;
            int endX2 = centerX - 30;
            int endY2 = centerY + 60;

            PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

            Sequence seq1 = new Sequence(finger1, 1);
            seq1.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX1, startY1));
            seq1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            //seq1.addAction(new Pause(finger1, Duration.ofMillis(50)));
            seq1.addAction(finger1.createPointerMove(GESTURE_DURATION, PointerInput.Origin.viewport(), endX1, endY1));
            seq1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            Sequence seq2 = new Sequence(finger2, 1);
            seq2.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX2, startY2));
            seq2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            //seq2.addAction(new Pause(finger2, Duration.ofMillis(50)));
            seq2.addAction(finger2.createPointerMove(GESTURE_DURATION, PointerInput.Origin.viewport(), endX2, endY2));
            seq2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            androidDriver.perform(Arrays.asList(seq1, seq2));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}