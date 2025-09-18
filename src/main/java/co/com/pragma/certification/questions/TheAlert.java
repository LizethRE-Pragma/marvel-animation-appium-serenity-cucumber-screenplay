package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.CommonPage.ALERT_LABEL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TheAlert implements Question<Boolean> {
    String message;

    public TheAlert(String message) {
        this.message = message;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(ALERT_LABEL(message), isCurrentlyVisible()).forNoMoreThan(5).seconds());
        return ALERT_LABEL(message).resolveFor(actor).isDisplayed();
    }


    public static TheAlert isDisplayed(String message) {
        return new TheAlert(message);
    }
}