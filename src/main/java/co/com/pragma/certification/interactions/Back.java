package co.com.pragma.certification.interactions;

import io.appium.java_client.android.AndroidDriver;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;


public class Back implements Interaction {
    @Override
    @Step("Back to the previous page")
    public <T extends Actor> void performAs(T actor) {
        AndroidDriver androidDriver = (AndroidDriver) ThucydidesWebDriverSupport.getProxiedDriver();

        androidDriver.navigate().back();
    }

    public static Back now() {
        return Tasks.instrumented(Back.class);
    }
}