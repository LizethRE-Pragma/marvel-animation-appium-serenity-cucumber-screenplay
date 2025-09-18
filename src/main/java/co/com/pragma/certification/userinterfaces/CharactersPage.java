package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CharactersPage {
    public static final Target SEARCH_BUTTON = Target.the("Search button").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")"));

    public static Target CHARACTER_CARD(String name, String nickName) {
        return Target.the("Character: " + nickName + " - " + name).located(AppiumBy.accessibilityId(nickName.toUpperCase() + '\n' + name));
    }

    public static final Target GENERAL_SECRET_PLACE_BUTTON = Target.the("SECRET PLACE button").located(AppiumBy.androidUIAutomator("new UiSelector().description(\"SECRET PLACE\").instance(0)"));
    public static final Target SEARCH_INPUT = Target.the("Search field").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")"));

    public static Target SEARCH_RESULTS_TEXT(String characterName, int number) {
        return Target.the("Character: " + characterName).located(AppiumBy.accessibilityId("Found " + number + " heroes for \"" + characterName + '"'));
    }

    public static Target CHARACTER_VIEW(String nickName) {
        return Target.the("Character: " + nickName).located(AppiumBy.accessibilityId(nickName));
    }

    public static final Target SECRET_PLACE_BUTTON = Target.the("SECRET PLACE button").located(AppiumBy.accessibilityId("SECRET PLACE"));
    public static final Target VIEW_DETAILS_BUTTON = Target.the("View Details button").located(AppiumBy.accessibilityId("View Details"));
}
