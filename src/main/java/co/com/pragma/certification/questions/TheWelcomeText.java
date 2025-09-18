package co.com.pragma.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.pragma.certification.userinterfaces.Menu.PROFILE_OPTION_MENU;
import static co.com.pragma.certification.userinterfaces.ProfilePage.WELCOME_TEXT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class TheWelcomeText implements Question<Boolean> {
    String userName;

    public TheWelcomeText(String userName) {
        this.userName = userName;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(PROFILE_OPTION_MENU, isCurrentlyVisible()).forNoMoreThan(10).seconds());
        actor.attemptsTo(Click.on(PROFILE_OPTION_MENU));
        return WELCOME_TEXT(userName).resolveFor(actor).isDisplayed();
    }


    public static TheWelcomeText isDisplayed(String userName) {
        return new TheWelcomeText(userName);
    }
}