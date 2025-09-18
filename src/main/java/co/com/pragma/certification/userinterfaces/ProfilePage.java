package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProfilePage {
    public static Target WELCOME_TEXT(String userName) {
        return Target.the("Username: " + userName).located(AppiumBy.accessibilityId("Hi " + userName));
    }

    public static final Target SIGN_OUT_BUTTON = Target.the("Sign Out button").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"));
    public static final Target SIGN_OUT_WINDOW_TITLE = Target.the("Sign out window title").located(AppiumBy.accessibilityId("Sign Out"));
    public static final Target SIGN_OUT_WINDOW_TEXT = Target.the("Sign out window text").located(AppiumBy.accessibilityId("Are you sure you want to sign out?"));
    public static final Target ACCEPT_BUTTON = Target.the("Accept button").located(AppiumBy.accessibilityId("Accept"));
    public static final Target CANCEL_BUTTON = Target.the("Cancel button").located(AppiumBy.accessibilityId("Cancel"));
}
