package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class Menu {
    public static final Target PROFILE_OPTION_MENU = Target.the("Profile option menu").located(AppiumBy.accessibilityId("Profile"));
    public static final Target CHARACTERS_OPTION_MENU = Target.the("Characters option menu").located(AppiumBy.accessibilityId("Characters"));
}
