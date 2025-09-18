package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class SingUpPage {
    public static final Target NAME_INPUT = Target.the("Name field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
    public static final Target EMAIL_INPUT = Target.the("Email field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
    public static final Target PASSWORD_INPUT = Target.the("Password field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
    public static final Target CONFIRM_YOUR_PASSWORD_INPUT = Target.the("Confirm your password field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
    public static final Target GENDER_DROPDOWN = Target.the("Gender field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(7)"));

    public static Target GENDER_OPTION(String gender) {
        return Target.the("Gender: " + gender.toUpperCase()).located(AppiumBy.accessibilityId(gender));
    }

    public static final Target TERMS_CHECK = Target.the("Terms check").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.CheckBox\")"));
    public static final Target SIGN_UP_BUTTON = Target.the("Sign up button").located(AppiumBy.accessibilityId("Sign Up"));
    public static final Target LOG_IN_BUTTON = Target.the("Log In button").located(AppiumBy.accessibilityId("Log In"));
}
