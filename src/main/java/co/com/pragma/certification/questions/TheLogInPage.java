package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.LogInPage.FORGOT_PASSWORD_BUTTON;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TheLogInPage implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(FORGOT_PASSWORD_BUTTON, isCurrentlyVisible()).forNoMoreThan(5).seconds());
        return FORGOT_PASSWORD_BUTTON.resolveFor(actor).isDisplayed();
    }

    public static TheLogInPage isDisplayed() {
        return new TheLogInPage();
    }
}