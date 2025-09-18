package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CommonPage {
    public static Target ALERT_LABEL(String message) {
        return Target.the("alert: " + message).located(AppiumBy.accessibilityId(message));
    }
}
