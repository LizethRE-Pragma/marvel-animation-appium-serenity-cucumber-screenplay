package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ResetPasswordPage {
    public static final Target BACK_BUTTON = Target.the("Back button").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(0)"));
    public static final Target TITLE_TEXT = Target.the("Reset password title").located(AppiumBy.accessibilityId("Reset password"));
    public static final Target EMAIL_INPUT = Target.the("Email field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));
    public static final Target SUBMIT_BUTTON = Target.the("Submit button").located(AppiumBy.accessibilityId("Submit"));
}
