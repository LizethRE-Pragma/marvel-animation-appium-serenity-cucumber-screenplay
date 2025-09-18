package co.com.pragma.certification.userinterfaces;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CharacterInformationPage {
    public static Target MARVEL_COMICS_CHARACTERS_BUTTON2(String nickName) {
        return Target.the("Character: " + nickName).located(AppiumBy.accessibilityId(nickName));
    }

    public static final Target MARVEL_COMICS_CHARACTERS_BUTTON = Target.the("View Marvel Comics Characters button").located(AppiumBy.accessibilityId("View Marvel Comics Characters"));
    public static final Target MARVEL_COMICS_CHARACTERS_TITLE = Target.the("Marvel Comics Characters title").located(AppiumBy.androidUIAutomator("new UiSelector().text(\"FEATURED CHARACTERS\")"));
    public static final Target MAP_MARKER = Target.the("Map Marker").located(AppiumBy.accessibilityId("Map Marker"));
    public static final Target MAP_VIEW = Target.the("Map").located(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)"));
}
