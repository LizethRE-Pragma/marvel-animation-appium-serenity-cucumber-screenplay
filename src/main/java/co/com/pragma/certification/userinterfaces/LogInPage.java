package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class LogInPage {
    public static final Target EMAIL_INPUT = Target.the("Email field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
    public static final Target PASSWORD_INPUT = Target.the("Password field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
    public static final Target FORGOT_PASSWORD_BUTTON = Target.the("Forgot Password button").located(AppiumBy.accessibilityId("Forgot Password"));
    public static final Target LOG_IN_BUTTON = Target.the("Log In button").located(AppiumBy.accessibilityId("Log In"));
    public static final Target SIGN_UP_BUTTON = Target.the("Sign up button").located(AppiumBy.accessibilityId("Sign up"));
}
